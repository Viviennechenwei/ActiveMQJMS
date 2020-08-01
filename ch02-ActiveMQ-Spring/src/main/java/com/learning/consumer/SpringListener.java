package com.learning.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringListener {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-consumer.xml");
    }
}
