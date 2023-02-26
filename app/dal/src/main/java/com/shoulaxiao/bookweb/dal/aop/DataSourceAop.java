package com.shoulaxiao.bookweb.dal.aop;

import com.shoulaxiao.bookweb.dal.annotations.DbContextHolder;
import com.shoulaxiao.bookweb.dal.annotations.DynamicSource;
import com.shoulaxiao.bookweb.dal.enums.DataSourceEnum;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

@Slf4j
@Aspect
@Component
public class DataSourceAop {

    @Pointcut("@annotation(com.shoulaxiao.bookweb.dal.annotations.DynamicSource)")
    public void pointCut() {

    }

    @Around("pointCut()")
    public Object switchDataSource(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature sign = (MethodSignature) joinPoint.getSignature();
        Method method = sign.getMethod();

        DynamicSource dynamicSource = findDynamicSource(joinPoint, method);
        if (dynamicSource != null) {
            log.info("切换数据源:{}", dynamicSource.value());
            DbContextHolder.set(dynamicSource.value());
        }
        log.info("当前方法:{}", method.getName());
        log.info("当前数据源:{}", DbContextHolder.get());

        try {
            return joinPoint.proceed();
        }finally {
            // 切换到默认数据源
            DbContextHolder.set(DataSourceEnum.BOOK_DB);
        }
    }

    private DynamicSource findDynamicSource(ProceedingJoinPoint joinPoint, Method target) {
        DynamicSource annotation;
        Optional<Method> first = Arrays.stream(joinPoint.getTarget().getClass().getMethods())
                .filter(method -> method.getName().equals(target.getName()))
                .findFirst();
        if (first.isPresent()) {
            annotation = AnnotationUtils.findAnnotation(first.get(), DynamicSource.class);
            if (annotation != null) {
                return annotation;
            }
        }
        return AnnotationUtils.findAnnotation(joinPoint.getTarget().getClass(), DynamicSource.class);

    }

}
