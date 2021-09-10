package com.examplsss.demo.redis;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @description:
 * @author: ljt
 * @time: 2021/9/10 0010 10:49
 */
public class PSTest {

    public static void main(String[] args) {

        // 连接本地redis服务端
        JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), "127.0.0.1", 6379);

        Publisher publisher = new Publisher(jedisPool);    //发布者
        publisher.start();

        SubThread subThread = new SubThread(jedisPool);  //订阅者
        subThread.start();


    }
}
