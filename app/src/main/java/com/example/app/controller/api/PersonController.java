package com.example.app.controller.api;

import com.example.app.model.Person;
import com.example.app.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/people")
public class PersonController {

    @Autowired
    private PersonRepository repository;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Person> getAllPeople() {
        return repository.findAll();
    }
}
