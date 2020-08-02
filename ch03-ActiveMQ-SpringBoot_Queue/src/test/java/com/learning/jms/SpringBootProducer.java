package com.learning.jms;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Ch03ActiveMqSpringBootApplication.class)
public class SpringBootProducer {

    @Value("${activemq.name}")
    String queueName;

    @Autowired
    JmsMessagingTemplate jmsMessagingTemplate;

    @Test
    public void ptpSender(){
        /**
         * 参数一：topic/queue的名字
         * 参数二：消息内容
         */
        jmsMessagingTemplate.convertAndSend(queueName,"This is springboot queue testing.");
        System.out.println("send message to springboot_queue successfully");
    }
}
