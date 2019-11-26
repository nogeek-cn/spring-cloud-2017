package com.darian.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <br>
 * <br>Darian
 **/
@SpringBootApplication
@EnableEurekaClient
public class UserServiceProviderBootstrapRibbon7070 {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceProviderBootstrapRibbon7070.class,args);
    }
}
