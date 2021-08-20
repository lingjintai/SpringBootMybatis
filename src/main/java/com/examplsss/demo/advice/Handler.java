package com.examplsss.demo.advice;

import com.examplsss.demo.dao.UserDao;
import com.examplsss.demo.service.UserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: ljt
 * @time: 2021/8/19 0019 15:15
 */
public class Handler implements InvocationHandler {

    private UserService target;
    private UserAdvice userAdvice;
    private UserDao userDao;

    public Handler() {
    }

    public Handler(UserService target, UserAdvice userAdvice) {
        this.target = target;
        this.userAdvice = userAdvice;
    }

    public Handler(UserService target, UserAdvice userAdvice, UserDao userDao) {
        this.target = target;
        this.userAdvice = userAdvice;
        this.userDao = userDao;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //加入增强方法
        userAdvice.beforeMethod(method);
        //业务方法
        System.out.println("方法名称:"+method.getName());
        Object invoke = method.invoke(target, args);
        //System.out.println(method);
        //加入增强方法
        userAdvice.afterMethod(method);
        return invoke;
    }

}
