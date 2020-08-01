package com.learning.consumer.queue.producer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) //junit与spring整合
@ContextConfiguration("classpath:application-producer.xml")//加载spring配置文件
public class SpringProducer {

    @Autowired
    @Qualifier("jmsQueueTemplate")
    JmsTemplate jmsQueueTemplate;

    @Autowired
    @Qualifier("jmsTopicTemplate")
    JmsTemplate jmsTopicTemplate;


    @Test
    public void queueProducer(){
        jmsQueueTemplate.send("spring_queue", session->session.createTextMessage("test spring queue producer"));
        System.out.println("message send successfully to spring_queue");
    }

    @Test
    public void topicProducer(){
        jmsTopicTemplate.send("spring_topic", session -> session.createTextMessage("test spring topic producer"));
        System.out.println("message send successfully to spring_topic");
    }
}
