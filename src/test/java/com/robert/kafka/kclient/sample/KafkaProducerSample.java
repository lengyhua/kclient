package com.robert.kafka.kclient.sample;

import com.alibaba.fastjson.JSON;
import com.robert.kafka.kclient.core.KafkaProducer;

/**
 * Sample for use {@link KafkaProducer} with Java API.
 * 
 * @author Robert Lee
 * @since Aug 21, 2015
 *
 */

public class KafkaProducerSample {
	public static void main(String[] args) throws InterruptedException {
		KafkaProducer kafkaProducer = new KafkaProducer(
				"kafka-producer.properties", "test");

		for (int i = 0; i < 100; i++) {
			Dog dog = new Dog();
			dog.setName("Yours " + i);
			dog.setId(i);
			kafkaProducer.sendWithTopic("test", JSON.toJSONString(dog));

			System.out.format("Sending dog: %d \n", i + 1);

			Thread.sleep(100);
		}
	}
}