package com.robert.kafka.kclient.boot;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * This annotation is used to declare a class to be a message handler
 * collection. This bean be also Spring @Component so that it can be
 * component-scanned by spring context.
 *
 * @author Robert Lee
 * @since Aug 21, 2015
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface KafkaHandlers {
}
