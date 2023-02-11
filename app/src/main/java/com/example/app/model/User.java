package com.example.app.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "user_data")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role {
        ADMIN, USER
    }
}
