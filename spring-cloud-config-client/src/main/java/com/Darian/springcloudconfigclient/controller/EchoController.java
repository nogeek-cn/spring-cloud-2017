package com.Darian.springcloudconfigclient.controller;

import com.Darian.springcloudconfigclient.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class EchoController {

    private final UserService userService;


    @Value("${name}")
    private String name;

    @Autowired
    public EchoController(UserService userService) {
        this.userService = userService;
    }

    //    @Async
    @GetMapping("/name")
    public String getName() {
        System.err.printf("Controller-[Thread: %s ]当前\"getName\"执行的线程，\n",
                Thread.currentThread().getName());
        userService.getName();
//        this.printThreadName();
        return name;
    }

    // 同一个类中，EchoController#getName()调用这个方法，并不会触发异步
    @Async
    public void printThreadName() {
        System.err.printf("[Thread: %s ]当前\"printThreadName\"执行的线程，\n\n",
                Thread.currentThread().getName());
//        int i = 1/ 0;
    }

}
