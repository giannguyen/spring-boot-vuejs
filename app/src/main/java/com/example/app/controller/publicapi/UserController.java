package com.example.app.controller.publicapi;

import com.example.app.dto.UserRequest;
import com.example.app.dto.UserResponse;
import com.example.app.model.Person;
import com.example.app.model.User;
import com.example.app.repository.PersonRepository;
import com.example.app.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public/users")
public class UserController {

    private ModelMapper modelMapper;
    private UserService userService;
    private PersonRepository personRepository;

    public UserController(ModelMapper modelMapper, UserService userService, PersonRepository personRepository) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.personRepository = personRepository;
    }

    @GetMapping
    public List<Person> getAllPeople() {
        return personRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        User user = modelMapper.map(userRequest, User.class);
        User createdUser = userService.createUser(user);
        UserResponse userResponse = modelMapper.map(createdUser, UserResponse.class);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }
}
