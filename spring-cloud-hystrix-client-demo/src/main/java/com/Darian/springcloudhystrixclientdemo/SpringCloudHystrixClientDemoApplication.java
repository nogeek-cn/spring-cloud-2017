package com.Darian.springcloudhystrixclientdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;


@SpringBootApplication
@EnableCircuitBreaker
public class SpringCloudHystrixClientDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudHystrixClientDemoApplication.class, args);
	}
}
