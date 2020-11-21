package com.robert.kafka.kclient.handlers;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.robert.kafka.kclient.excephandler.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * This class converts the JSON string to a single JSON object, and then make it
 * available to be processed by any subclass.
 *
 * @author Robert Lee
 * @since Aug 21, 2015
 */
public abstract class ObjectMessageHandler<T> extends SafelyMessageHandler {
    protected static Logger log = LoggerFactory
            .getLogger(ObjectMessageHandler.class);

    public ObjectMessageHandler() {
        super();
    }

    public ObjectMessageHandler(ExceptionHandler excepHandler) {
        super(excepHandler);
    }

    public ObjectMessageHandler(List<ExceptionHandler> excepHandlers) {
        super(excepHandlers);
    }

    protected void doExecute(String message) {
        JSONObject jsonObject = JSON.parseObject(message);
        doExecuteObject(jsonObject);
    }

    protected abstract void doExecuteObject(JSONObject jsonObject);
}
