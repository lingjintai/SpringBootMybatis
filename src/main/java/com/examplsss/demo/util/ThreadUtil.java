package com.examplsss.demo.util;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: ljt
 * @time: 2022/2/21 0021 16:37
 */
public class ThreadUtil {

    private static final int MIXED_MAX = 128; //最大线程池数
    private static final String MIXED_AMOUNT = "mixed.thread.amount";

    //懒汉式单例建线程池 用户混合型任务
    private static class MixedTargetThreadPool {
      static {

      }

        private static final int max = 128;
        private static final ExecutorService executorService = new ThreadPoolExecutor(
                max,
                max,
                0L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(128),
                new ThreadFactoryBuilder().setDaemon(false).setNameFormat("混合型线程池").build(),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
    }
}
