package com.examplsss.demo.task;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: ljt
 * @time: 2021/9/9 0009 9:46
 */
public class MyTask implements Runnable{


    @Override
    public void run() {

        try {
            TimeUnit.SECONDS.sleep(10);


            System.out.println("当前线程名字是 "+Thread.currentThread().getName());
        }catch (Exception e){
            e.printStackTrace();
        }

    }



}
