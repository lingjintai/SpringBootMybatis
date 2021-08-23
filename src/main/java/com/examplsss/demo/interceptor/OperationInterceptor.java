package com.examplsss.demo.interceptor;

import com.examplsss.demo.annotation.Operate;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @description:
 * @author: ljt
 * @time: 2021/8/20 0020 10:23
 */
@Aspect
@Component
@Slf4j
public class OperationInterceptor {


    @Around("@annotation(com.examplsss.demo.annotation.Operate)")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Operate operate = null;
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.
                getMethods();
        for (Method method : methods) {
            log.info("name->{}", method.getName());
            log.info("name->{} id->{}",1,2);
            if (method.getName().equals(methodName) && method.isAnnotationPresent(Operate.class)) {
                operate = method.getAnnotation(Operate.class);
            }
        }
        //获取方法参数值数组
        Object[] args = joinPoint.getArgs();
        Object object = joinPoint.proceed(args);
        log.info("args->{}",args);

        System.out.println("保存操作记录:" + operate.type() + "--" + operate.desc());
        return object;
    }


}
