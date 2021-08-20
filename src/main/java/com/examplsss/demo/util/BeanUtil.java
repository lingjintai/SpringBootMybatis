package com.examplsss.demo.util;

import org.springframework.context.ConfigurableApplicationContext;

/**
 * @description:
 * @author: ljt
 * @time: 2021/8/19 0019 16:04
 */
public class BeanUtil {

    public static ConfigurableApplicationContext applicationContext;
    //定义一个获取已经实例化bean的方法
    public static <T> T getBean(Class<T> c){
        return applicationContext.getBean(c);
    }

}
