package com.examplsss.demo.advice;

import java.lang.reflect.Method;

/**
 * @description:
 * @author: ljt
 * @time: 2021/8/19 0019 15:09
 */
public class MyLogger implements UserAdvice {
    @Override
    public void beforeMethod(Method method) {
        System.out.println("执行前置通知");
    }

    @Override
    public void afterMethod(Method method) {
        System.out.println("执行后置通知");
    }
}
