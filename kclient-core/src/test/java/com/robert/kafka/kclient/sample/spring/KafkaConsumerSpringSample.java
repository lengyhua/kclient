package com.robert.kafka.kclient.sample.spring;

import com.robert.kafka.kclient.core.KafkaConsumer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Sample for use {@link KafkaConsumer} with Spring context.
 *
 * @author Robert Lee
 * @since Aug 21, 2015
 */

public class KafkaConsumerSpringSample {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                "kafka-consumer.xml");

        KafkaConsumer kafkaConsumer = (KafkaConsumer) ac.getBean("consumer");
        try {
            kafkaConsumer.startup();

            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            kafkaConsumer.shutdownGracefully();
        }
    }
}
