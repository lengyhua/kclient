package com.robert.kafka.kclient.boot;

import com.robert.kafka.kclient.core.KafkaConsumer;
import com.robert.kafka.kclient.core.KafkaProducer;
import com.robert.kafka.kclient.excephandler.ExceptionHandler;

import java.util.List;

/**
 * The context class which stores the runtime Kafka processor reference.
 *
 * @author Robert Lee
 * @since Aug 21, 2015
 */
public class KafkaHandler {
    private KafkaConsumer kafkaConsumer;

    private KafkaProducer kafkaProducer;

    private List<ExceptionHandler> exceptionHandlers;

    private KafkaHandlerMeta kafkaHandlerMeta;

    public KafkaHandler(KafkaConsumer kafkaConsumer,
                        KafkaProducer kafkaProducer, List<ExceptionHandler> exceptionHandlers,
                        KafkaHandlerMeta kafkaHandlerMeta) {
        super();
        this.kafkaConsumer = kafkaConsumer;
        this.kafkaProducer = kafkaProducer;
        this.exceptionHandlers = exceptionHandlers;
        this.kafkaHandlerMeta = kafkaHandlerMeta;
    }

    public KafkaConsumer getKafkaConsumer() {
        return kafkaConsumer;
    }

    public void setKafkaConsumer(KafkaConsumer kafkaConsumer) {
        this.kafkaConsumer = kafkaConsumer;
    }

    public KafkaProducer getKafkaProducer() {
        return kafkaProducer;
    }

    public void setKafkaProducer(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    public List<ExceptionHandler> getExceptionHandlers() {
        return exceptionHandlers;
    }

    public void setExceptionHandlers(List<ExceptionHandler> exceptionHandlers) {
        this.exceptionHandlers = exceptionHandlers;
    }

    public KafkaHandlerMeta getKafkaHandlerMeta() {
        return kafkaHandlerMeta;
    }

    public void setKafkaHandlerMeta(KafkaHandlerMeta kafkaHandlerMeta) {
        this.kafkaHandlerMeta = kafkaHandlerMeta;
    }

}
