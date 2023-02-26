package com.shoulaxiao.bookweb.common.aspect;

import com.shoulaxiao.bookweb.common.category.LogModuleEnum;
import com.shoulaxiao.bookweb.common.category.SceneEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @athor : shoulaxiao
 * @description:
 * @date: 2021-03-16 19:21
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogPerform {

    SceneEnum sourceEnum() default SceneEnum.LOGIN_IN;

    LogModuleEnum logModuleEnum() default LogModuleEnum.AUTHORIZE;

    boolean printReq() default true;

    boolean printResp() default false;

    boolean isRemove() default false;
}
