package com.example.demo.client;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value="internal", url="${client.internal}")
public interface InternalClient {

    @GetMapping(value="/hello/{name}")
    public String getHello(@PathVariable final String name);
}
