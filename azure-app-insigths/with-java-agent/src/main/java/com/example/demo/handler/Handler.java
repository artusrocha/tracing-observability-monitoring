package com.example.demo.handler;

import org.springframework.stereotype.Component;

import com.example.demo.client.InternalClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class Handler {

    private final InternalClient client;

    private static final Logger logger = LoggerFactory.getLogger(Handler.class);

    Handler(final InternalClient client) {
        this.client = client;
    }

    public String handleIt(final String name) {
        logger.info("Handler.handleIt name={}", name);
        String resp = client.getHello(name);
        logger.info("Handler.handleIt resp='{}'", resp);
        return resp;
    }
}