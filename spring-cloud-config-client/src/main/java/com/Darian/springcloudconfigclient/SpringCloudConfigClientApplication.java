package com.Darian.springcloudconfigclient;

import com.Darian.springcloudconfigclient.health.MyHealthIndicator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;

import java.util.HashMap;
import java.util.Map;


@SpringBootApplication
public class SpringCloudConfigClientApplication {

    public static void main(String[] args) {
//        SpringApplication springApplication = new SpringApplication();
//        springApplication.setWebEnvironment(true);
//        springApplication.run(args);

        SpringApplication.run(SpringCloudConfigClientApplication.class, args);
    }

    @Order(Ordered.HIGHEST_PRECEDENCE)
    @Configuration
    public static class MyPropertySourceLocator implements PropertySourceLocator {

        @Override
        public PropertySource<?> locate(Environment environment) {
            HashMap<String, Object> source = new HashMap<>();
//            source.put("server.port","9090");
            MapPropertySource propertySource = new MapPropertySource("my-property-source", source);
            return propertySource;
        }
    }


    //
//    private final ContextRefresher contextRefresher;
//
//    private final Environment environment;
//
//    @Autowired
//    public SpringCloudConfigClientDemoApplication(ContextRefresher contextRefresher, Environment environment) {
//        this.contextRefresher = contextRefresher;
//        this.environment = environment;
//    }

    @Bean
    public MyHealthIndicator myHealthIndicator(){
        return new MyHealthIndicator();
    }

    // 异步
//    @Async

//    @Scheduled(fixedRate = 5 * 1000, initialDelay = 3 * 1000)
//    public void autoRefresh() {
//
//        Set<String> updatedPropertyNames = contextRefresher.refresh();
//
//        updatedPropertyNames.forEach(propertyName ->
//                System.err.printf("[Thread: %s ]当前配置已经更新，" +
//                                "具体Key：%s , Value : %s \n",
//                        Thread.currentThread().getName(),
//                        propertyName,
//                        environment.getProperty(propertyName)));
//
//    }

    public void onNext(Object value){

    }

    public void onComplete(Object value){

    }

    public void onError(Object value){

    }
}
