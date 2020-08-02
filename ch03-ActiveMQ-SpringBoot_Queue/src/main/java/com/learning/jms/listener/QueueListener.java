package com.learning.jms.listener;

import org.apache.activemq.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@Component
public class QueueListener {

    @JmsListener(destination = "${activemq.name}")
    public void receiveMessage(Message message) throws JMSException {
        if(message instanceof TextMessage){
            TextMessage textMessage = (TextMessage) message;
            System.out.println("received message from springboot_queue: " + textMessage.getText());
        }
    }
}
