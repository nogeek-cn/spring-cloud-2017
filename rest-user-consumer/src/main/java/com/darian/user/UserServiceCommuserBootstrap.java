package com.darian.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * <br>用户服务消费
 * <br>Darian
 **/
@SpringBootApplication
@EnableEurekaClient
public class UserServiceCommuserBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceCommuserBootstrap.class,args);
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


}
