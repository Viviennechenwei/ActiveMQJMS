package com.learning.consumer.topic.producer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class PSProducer {

    //发布订阅模式（Topic）- 消息生产者demo
    public static void main(String[] args) throws JMSException {
        //1、创建连接工厂
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        //2、创建连接
        Connection connection = factory.createConnection();
        //3、打开连接
        connection.start();
        //4、创建session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5、创建目标地址（Queue/Topic）
        Destination destination = session.createTopic("testTopic1");
        //6、创建消息生产者
        MessageProducer producer = session.createProducer(destination);
        //7、创建消息
        TextMessage textMessage = session.createTextMessage("test topic1 message");
        //8、发送消息
        producer.send(textMessage);
        System.out.println("message2 send success to testTopic1");
        //9、释放资源
        session.close();
        connection.close();
    }


}
