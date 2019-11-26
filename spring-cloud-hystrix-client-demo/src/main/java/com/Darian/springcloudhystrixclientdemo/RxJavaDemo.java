package com.Darian.springcloudhystrixclientdemo;

import org.springframework.scheduling.annotation.Scheduled;
import rx.Observer;
import rx.Single;
import rx.schedulers.Schedulers;

import java.util.Random;

/**
 * <br>ReactiveX Java Demo
 * <br>Darian
 **/
public class RxJavaDemo {

    public static void main(String[] args) {

        Random random = new Random();

        Single.just("hello, world") // just 发布数据
                .observeOn(Schedulers.immediate()) // 订阅的线程池： immediate = Thread.currentThread()
                .subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() { // 正常结束流程
                        System.out.println("执行结束！");
                    }

                    @Override
                    public void onError(Throwable e) {// 异常流程
                        System.out.println("熔断保护！");
                    }

                    @Override
                    public void onNext(String s) { // 数据消费 s= “hello world”
                        // 如果随机事件大于 100， 那么触发容错
                        int value = random.nextInt(200);
                        if (value > 100) {
                            throw new RuntimeException("time out!");
                        }
                        System.out.println("Hello world() costs " + value + "ms.");
                    }
                });
    }
}
