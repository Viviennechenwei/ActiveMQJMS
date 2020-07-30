package com.learning.queue.consumer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class PTPConsumer01 {

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
        Destination destination = session.createQueue("testQueue1");
        //6、创建消息的消费者
        MessageConsumer consumer = session.createConsumer(destination);
        //7、配置消息监听器
        while(true){
            Message message = consumer.receive();
            if(message == null){
                break;
            }
            if(message instanceof TextMessage){
                TextMessage textMessage = (TextMessage) message;
                System.out.println(textMessage.getText());
            }
        }
    }
}
