package com.darian.spring.cloud.feign.api.hystrix;

import com.darian.spring.cloud.feign.api.domain.Person;
import com.darian.spring.cloud.feign.api.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.Collections;

/**
 * <br>
 * <br>Darian
 **/
public class PersonServiceFallback implements PersonService {
    @Override
    public boolean save(Long id, String name) {
        return false;
    }

    @Override
    public Collection<Person> findAll() {
        return Collections.emptyList();
    }
}
