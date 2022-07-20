package com.example.demo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerFactory;

@RestController
@RequestMapping("/api/v1")
class Controller {

    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    @GetMapping("/hello")
    public String hello() {
        logger.info("/hello request....");
        return "Hello world!";
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable() final String name) {
        logger.info("/hello/{} request....", name);
        return "Hello " + name + "!";
    }

}