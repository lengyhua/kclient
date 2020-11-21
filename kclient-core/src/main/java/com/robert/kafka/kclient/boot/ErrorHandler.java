package com.robert.kafka.kclient.boot;

import java.lang.annotation.*;

/**
 * This annotation is used for a method which serve as an exception handler. It
 * includes the metadata for an exception handler.
 *
 * @author Robert Lee
 * @since Aug 21, 2015
 */

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ErrorHandler {
    Class<? extends Throwable> exception() default Throwable.class;

    String topic() default "";
}
