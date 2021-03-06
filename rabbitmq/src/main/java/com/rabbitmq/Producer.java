package com.rabbitmq;

import com.Utils.RabbitMQUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    public static final String QUEUE_NAME = "hello";
    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMQUtils.getChanel();
        /**
         *  生成一个队列
         *  1.队列名称
         *  2.队列里面的消息是否持久化（硬盘） 默认情况消息存储在内存中
         *  3.该队列是否只供一个消费者进行消费，是否进行消息共享，true可以多个消费者进行消费，false只能一个消费者消费
         *  4.是否自动删除 最后一个消费者断开链接以后 该队列是否自动删除 true自动 false不自动给
         *  5.其他参数
         */
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        //发消息
        String message = "hello world"; //初次使用
        /**
         * 发送一个消息
         * 1.发送到哪个交换机
         * 2.路由的Key值是哪个 本次是队列的名称
         * 3.其他参数信息
         * 4.发送消息的消息体
         */
        channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
        System.out.println("消息发送完毕");

    }
}
