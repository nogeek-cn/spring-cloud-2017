package com.darian.spring.cloud.feign.controller;


import com.darian.spring.cloud.feign.api.domain.Person;
import com.darian.spring.cloud.feign.api.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * <br>
 * <br>Darian
 **/
@RestController
public class PersonClientController implements PersonService {

    private final PersonService personService;

    @Autowired
    public PersonClientController(PersonService personService) {
        this.personService = personService;
    }


    @Override
    public boolean save(@RequestParam Long id, @RequestParam String name) {
        return personService.save(id, name);
    }

    @Override
    public Collection<Person> findAll() {
        return personService.findAll();
    }


}
