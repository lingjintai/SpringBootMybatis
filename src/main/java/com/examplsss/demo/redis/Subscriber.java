package com.examplsss.demo.redis;

import redis.clients.jedis.JedisPubSub;

/**
 * @description:
 * @author: ljt
 * @time: 2021/9/10 0010 10:34
 */
public class Subscriber extends JedisPubSub {

    public Subscriber(){}
    @Override
    public void onMessage(String channel, String message) {       //收到消息会调用
        System.out.println(String.format("receive redis published message, channel %s, message %s", channel, message));
    }

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {    //订阅了频道会调用
        System.out.println(String.format("subscribe redis channel success, channel %s, subscribedChannels %d",
                channel, subscribedChannels));
    }
    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {   //取消订阅 会调用
        System.out.println(String.format("unsubscribe redis channel, channel %s, subscribedChannels %d",
                channel, subscribedChannels));

    }

}
