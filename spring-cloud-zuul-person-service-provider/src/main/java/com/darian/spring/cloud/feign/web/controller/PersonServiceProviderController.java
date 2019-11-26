package com.darian.spring.cloud.feign.web.controller;

import com.darian.spring.cloud.feign.api.domain.Person;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <br>
 * <br>Darian
 **/
@RestController
public class PersonServiceProviderController {

    private final static Random random = new Random();

    private static Map<Long, Person> personMap = new ConcurrentHashMap<>();

    static {
        personMap.put(1L, new Person(1L, "id-1"));
        personMap.put(2L, new Person(2L, "id-2"));
        personMap.put(3L, new Person(3L, "id-3"));
    }
    /**
     * 保存
     * <br>Darian
     **/
    @GetMapping("person/save")
    public boolean save(@RequestParam("id") Long id,
                        @RequestParam("name") String name) {
        return personMap.put(id, new Person(id, name)) == null;
    }

    /**
     * 查找所有
     * <br>Darian
     **/
    @GetMapping("person/find/all")
    @HystrixCommand(
            fallbackMethod = "fallbackForAllPersons",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds"
                            , value = "100")
            }
    )
    public Collection<Person> findAll() throws Exception {
        int value = random.nextInt(200);
        Thread.sleep(value);
        System.out.println("findAll() costs" + value + " ms.");
        return personMap.values();
    }

    /**
     * {@link  #findAll()}FallBack 方法
     * <br>Darian
     **/
    public Collection<Person> fallbackForAllPersons() {
        System.err.println("fallbackForAllPersons() is invoked");
        return Collections.emptyList();
    }

}
