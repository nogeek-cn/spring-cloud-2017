package com.Darian.springcloudhystrixclientdemo.controller;


import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * <br>
 * <br>Darian
 **/
@RestController
public class HystrixDemoController {

    private final static Random random = new Random();


    @GetMapping("hello-world-2")
    public String helloWorld2() {
        return new hellwWorldCommand().execute();
    }

    /**
     * 编程的方式
     * <br>Darian
     **/
    private class hellwWorldCommand extends com.netflix.hystrix.HystrixCommand<String> {

        protected hellwWorldCommand() {
            super(HystrixCommandGroupKey.Factory.asKey("HelloWorld"),
                    100);
        }

        @Override
        protected String run() throws Exception {
            // 如果随机事件大于 100， 那么触发容错
            int value = random.nextInt(200);

            System.out.println("Hello world() costs " + value + "ms.");
            Thread.sleep(value);

            return "Hello world";
        }

        protected String getFallBack() {
            return HystrixDemoController.this.errorContent();
        }
    }


    /**
     * 当 {@link #helloWorld()} 方法调用超时或失败时
     * fallback 方法 {@link #errorContent()} 作为替代返回
     * <br>Darian
     **/
    @GetMapping("hello-world")
    @HystrixCommand(
            fallbackMethod = "errorContent",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
                            value = "100")
            })
    public String helloWorld() throws InterruptedException {
        // 如果随机事件大于 100， 那么触发容错
        int value = random.nextInt(200);

        System.out.println("Hello world() costs " + value + "ms.");
        Thread.sleep(value);

        return "Hello world";
    }

    public String errorContent() {
        return "Fault";
    }

}
