package com.shoulaxiao.bookweb.dal.annotations;

import com.shoulaxiao.bookweb.dal.enums.DataSourceEnum;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DynamicSource {

    DataSourceEnum value();
}
