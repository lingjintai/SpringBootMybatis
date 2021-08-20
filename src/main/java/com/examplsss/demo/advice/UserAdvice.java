package com.examplsss.demo.advice;

import java.lang.reflect.Method;

/**
 * @description:
 * @author: ljt
 * @time: 2021/8/19 0019 15:08
 */
public interface UserAdvice {

    void beforeMethod(Method method);
    void afterMethod(Method method);

}
