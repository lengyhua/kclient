package com.robert.kafka.kclient.handlers;

import com.robert.kafka.kclient.excephandler.DefaultExceptionHandler;
import com.robert.kafka.kclient.excephandler.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * This is an abstract class which handle exception by exception handlers if it
 * happens.
 *
 * @author Robert Lee
 * @since Aug 21, 2015
 */
public abstract class SafelyMessageHandler implements MessageHandler {
    protected static Logger log = LoggerFactory
            .getLogger(SafelyMessageHandler.class);

    private final List<ExceptionHandler> exceptionHandlers = new ArrayList<ExceptionHandler>();

    {
        exceptionHandlers.add(new DefaultExceptionHandler());
    }

    public SafelyMessageHandler() {

    }

    public SafelyMessageHandler(ExceptionHandler excepHandler) {
        this.exceptionHandlers.add(excepHandler);
    }

    public SafelyMessageHandler(List<ExceptionHandler> exceptionHandlers) {
        this.exceptionHandlers.addAll(exceptionHandlers);
    }

    public void execute(String message) {
        try {
            doExecute(message);
        } catch (Throwable t) {
            handleException(t, message);
        }
    }

    protected void handleException(Throwable t, String message) {
        for (ExceptionHandler exceptionHandler : exceptionHandlers) {
            if (t.getClass() == IllegalStateException.class
                    && t.getCause() != null
                    && t.getCause().getClass() == InvocationTargetException.class
                    && t.getCause().getCause() != null)
                t = t.getCause().getCause();

            if (exceptionHandler.support(t)) {
                try {
                    exceptionHandler.handle(t, message);
                } catch (Exception e) {
                    log.error(
                            "Exception happens when the handler {} is handling the exception {} and the message {}. Please check if the exception handler is configured properly.",
                            exceptionHandler.getClass(), t.getClass(), message);
                    log.error(
                            "The stack of the new exception on exception is, ",
                            e);
                }
            }
        }

    }

    protected abstract void doExecute(String message);

    public List<ExceptionHandler> getExceptionHandlers() {
        return exceptionHandlers;
    }

    public void setExceptionHandlers(List<ExceptionHandler> exceptionHandlers) {
        this.exceptionHandlers.addAll(exceptionHandlers);
    }

    public void addExcepHandler(ExceptionHandler excepHandler) {
        this.exceptionHandlers.add(excepHandler);
    }

}
