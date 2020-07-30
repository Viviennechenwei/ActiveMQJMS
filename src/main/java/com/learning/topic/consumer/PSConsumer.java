package com.learning.topic.consumer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class PSConsumer {

    public static void main(String[] args) throws JMSException {
        //1、创建连接工厂
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        //2、创建连接
        Connection connection = factory.createConnection();
        //3、打开连接
        connection.start();
        //4、创建session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5、指定目标地址
        Destination destination = session.createTopic("testTopic1");
        //6、创建消息的消费者
        MessageConsumer consumer = session.createConsumer(destination);
        //7、设置消息监听器来接收消息
        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                if (message instanceof TextMessage){
                    TextMessage message1 = (TextMessage)message;
                    try {
                        System.out.println(message1.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        //注意：在监听器模式下不能关闭连接，一旦关闭，消息无法接收
    }
}
