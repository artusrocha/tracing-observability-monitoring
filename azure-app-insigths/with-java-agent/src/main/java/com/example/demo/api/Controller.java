package com.example.demo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;

// import ch.qos.logback.classic.Logger;
// import ch.qos.logback.classic.LoggerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import com.example.demo.handler.Handler;

@RestController
class Controller {

    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    private final Handler handler;

    Controller (final Handler handler) {
        this.handler = handler;
    }

    @GetMapping("/")
    public Map<String, Object> root(@RequestHeader HttpHeaders headers,
                                    @RequestParam Map<String,String> params) {
        logger.info("headers: {}, params: {}", headers, params);
        final String resp = handler.handleIt("test");
        return Map.of("headers", headers, "params", params, "internal_resp", resp);
    }

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