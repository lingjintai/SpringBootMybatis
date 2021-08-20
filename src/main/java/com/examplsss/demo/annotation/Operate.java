package com.examplsss.demo.annotation;

import java.lang.annotation.*;

/**
 * @description:
 * @author: ljt
 * @time: 2021/8/20 0020 10:15
 */
@Target({ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Operate {


    /**
     * 操作描述
     */
    String desc() default "";

    /**
     * 操作类型
     */
    String type() default "";



}
