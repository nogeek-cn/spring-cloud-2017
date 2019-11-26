package com.darian.springcloudsleuthdemo.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * <br> Demo Controller
 * <br>Darian
 **/
@RestController
public class DemoController {

    /**
     * 加不加 static 是一样的，都有缓存的。
     * <br>Darian
     **/
    private final static Logger logger = LoggerFactory.getLogger(DemoController.class);

    private final RestTemplate restTemplate;

    @Autowired
    public DemoController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("")
    public String index() {
        String returnValue = "Hello, World";
        logger.info("{} index() {}", getClass().getSimpleName(), returnValue);
        return returnValue;
    }

    /**
     * 完整的调用链路：
     * <p>
     * spring-cloud-sleuth
     * -> zuul
     * -> person-client
     * -> person-service
     * <br>Darian
     **/
    @GetMapping("/to/zuul/person-client/person/find/all")
    public Object toZuul() {
        logger.info("{} index() {}", getClass().getSimpleName());
        // Spring-cloud-zuul:7070
        String url = "http://spring-cloud-zuul/person-client/person/find/all";
        return restTemplate.getForObject(
            url,Object.class );
    }


}
