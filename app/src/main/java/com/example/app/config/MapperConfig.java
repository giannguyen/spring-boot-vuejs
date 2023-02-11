package com.example.app.config;

import com.example.app.dto.UserRequest;
import com.example.app.dto.UserResponse;
import com.example.app.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.createTypeMap(UserRequest.class, User.class)
                .addMappings(mapper -> mapper.using(ctx -> User.Role.valueOf((String) ctx.getSource()))
                        .map(UserRequest::getRole, User::setRole));
        modelMapper.createTypeMap(User.class, UserResponse.class)
                .addMappings(mapper -> mapper.using(ctx -> ((User.Role) ctx.getSource()).name())
                        .map(User::getRole, UserResponse::setRole));


        return modelMapper;
    }

}
