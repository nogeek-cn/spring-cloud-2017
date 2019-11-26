package com.darian.spring.cloud.feign.api.service;

import com.darian.spring.cloud.feign.api.domain.Person;
import com.darian.spring.cloud.feign.api.hystrix.PersonServiceFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

/**
 * <br>
 * <br>Darian
 **/
@FeignClient(value = "person-service",fallback = PersonServiceFallback.class)// 服务提供方应用的名称
public interface PersonService {

    /**
     * 保存
     * <br>Darian
     **/
    @GetMapping("person/save")
    boolean save(@RequestParam("id") Long id,
                 @RequestParam("name") String name);

    /**
     * 查找所有
     * <br>Darian
     **/
    @GetMapping("person/find/all")
    Collection<Person> findAll();
}
