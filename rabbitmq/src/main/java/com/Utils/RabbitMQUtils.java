package com.Utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitMQUtils {
    public static Channel getChannel() throws IOException, TimeoutException {
        //创建链接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //工厂IP 链接RabbitMQ的队列
        factory.setHost("192.168.200.130");
        //用户名和密码
        factory.setUsername("admin");
        factory.setPassword("123");
        //创建链接
        Connection connection = factory.newConnection();
        //获取信道
        Channel channel = connection.createChannel();
        return channel;
    }
}
