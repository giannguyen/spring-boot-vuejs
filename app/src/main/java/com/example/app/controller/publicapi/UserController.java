package com.example.app.controller.publicapi;

import com.example.app.dto.LoginRequest;
import com.example.app.dto.UserRequest;
import com.example.app.dto.UserResponse;
import com.example.app.model.User;
import com.example.app.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public/users")
public class UserController {

    private ModelMapper modelMapper;
    private UserService userService;
    private PasswordEncoder passwordEncoder;

    public UserController(ModelMapper modelMapper, UserService userService, PasswordEncoder passwordEncoder) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        User user = modelMapper.map(userRequest, User.class);
        User createdUser = userService.createUser(user);
        UserResponse userResponse = modelMapper.map(createdUser, UserResponse.class);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> userLogin(@RequestBody LoginRequest loginRequest) {
        User user = userService.findByUserName(loginRequest.getUsername());
        if (user != null && passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            UserResponse userResponse = modelMapper.map(user, UserResponse.class);
            return ResponseEntity.ok(userResponse);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
