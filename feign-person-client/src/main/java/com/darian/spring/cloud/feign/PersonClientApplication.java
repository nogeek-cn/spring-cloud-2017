package com.darian.spring.cloud.feign;


import com.darian.spring.cloud.feign.api.service.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * <br>
 * <br>Darian
 **/
@SpringBootApplication
@EnableFeignClients(clients = PersonService.class)
@EnableEurekaClient
public class PersonClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonClientApplication.class, args);
    }
}
