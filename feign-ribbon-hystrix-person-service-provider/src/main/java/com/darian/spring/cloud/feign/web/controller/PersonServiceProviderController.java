package com.darian.spring.cloud.feign.web.controller;

import com.darian.spring.cloud.feign.api.domain.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <br>
 * <br>Darian
 **/
@RestController
public class PersonServiceProviderController {

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
    public boolean save(@RequestParam Long id, @RequestParam String name) {
        return personMap.put(id, new Person(id, name)) == null;
    }

    /**
     * 查找所有
     * <br>Darian
     **/
    @GetMapping("person/find/all")
    public Collection<Person> findAll() {
        return personMap.values();
    }
}
