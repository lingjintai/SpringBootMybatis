package com.examplsss.demo.task.threadPool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.util.concurrent.*;

/**
 * @description:
 * @author: ljt
 * @time: 2021/9/9 0009 9:53
 */
@Slf4j
@Component
@Order(1)
public class MyTaskThreadPool implements CommandLineRunner {

    public static ExecutorService LZ_PUSH_POOL = null;

    @Override
    public void run(String... args) throws Exception {
        int corePoolSize = Runtime.getRuntime().availableProcessors();
        if (corePoolSize < 1) {
            corePoolSize = 1;
        }
        int maxPoolSize = corePoolSize * 2 + 1;

        ThreadFactory dsada = new CustomizableThreadFactory("dsada");

        if (null == LZ_PUSH_POOL) {
            LZ_PUSH_POOL = new ThreadPoolExecutor(corePoolSize, maxPoolSize,
                    0L, TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<>(128),
                    new ThreadFactoryBuilder().setNameFormat("myTask-pool-%d").setDaemon(false).build(),
                    new ThreadPoolExecutor.CallerRunsPolicy());
        }
        log.error("初始化线程池");
    }

    @PreDestroy
    public void destroy() {
        if (null != LZ_PUSH_POOL) {
            LZ_PUSH_POOL.shutdown();
        }
        log.error("销毁线程池!");
    }

}
