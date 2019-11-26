package com.darian.spring.cloud.feign;


import com.darian.spring.cloud.feign.api.domain.Person;
import com.darian.spring.cloud.feign.api.service.PersonService;
import com.darian.spring.cloud.feign.ribbon.FirstServerForeverRule;
import feign.Client;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;

/**
 * <br>
 * <br>Darian
 **/
@SpringBootApplication
@EnableFeignClients(clients = PersonService.class)
@EnableEurekaClient
//@RibbonClient( value = "person-service",configuration = PersonClientApplication.class)
@EnableHystrix
public class PersonClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonClientApplication.class, args);
    }

    @Bean
    public FirstServerForeverRule firstServerForeverRule(){

        return new FirstServerForeverRule();
    }
}
