package com.examplsss.demo.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description:
 * @author: ljt
 * @time: 2021/9/10 0010 10:30
 */
public class Publisher extends Thread {

    private final JedisPool jedisPool;

    public Publisher(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Jedis jedis = jedisPool.getResource();   //连接池中取出一个连接
        while (true) {
            try {
                jedis.publish("mychannel", reader.readLine());   //从 mychannel 的频道上推送消息
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
