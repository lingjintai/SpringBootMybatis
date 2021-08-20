package com.examplsss.demo.proxy;

import com.examplsss.demo.service.UserService;
import com.examplsss.demo.service.impl.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: ljt
 * @time: 2021/8/19 0019 13:49
 */
public class UserProxy {

    private UserServiceImpl  userServiceImp =new UserServiceImpl();

    public  UserService getUserService(){
        UserService  proxyObject =(UserService) Proxy.newProxyInstance(userServiceImp.getClass().getClassLoader(), userServiceImp.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object invoke=null;
                if (method.getName().equals("Sel")) {
                    System.out.println(1111);
                    invoke = method.invoke(proxy, args);
                    System.out.println(1111);
                }
                return invoke;
            }
        });
        return  proxyObject;
    }
}
