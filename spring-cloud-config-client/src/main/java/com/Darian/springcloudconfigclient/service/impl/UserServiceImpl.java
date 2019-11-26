package com.Darian.springcloudconfigclient.service.impl;

import com.Darian.springcloudconfigclient.service.UserService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Async
    @Override
    public void getName() {
        System.err.printf("Service-[Thread: %s ]当前\"printThreadName\"执行的线程，\n\n",
                Thread.currentThread().getName());

    }
}
