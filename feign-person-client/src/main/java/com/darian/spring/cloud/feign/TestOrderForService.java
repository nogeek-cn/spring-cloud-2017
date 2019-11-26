package com.darian.spring.cloud.feign;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestOrderForService implements ApplicationContextAware {
    @Autowired
    private List<TestInterface> testIList;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        testIList.forEach(System.out::println);
    }
}

interface TestInterface {
}

@Order(56)
//@Order(-56)
@Service
class Service1 implements TestInterface {
}

@Order(-56)
//@Order(56)
@Service
class Service2 implements TestInterface {
}