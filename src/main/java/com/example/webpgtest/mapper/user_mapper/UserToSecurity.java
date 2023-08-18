package com.example.webpgtest.mapper.user_mapper;

import com.example.webpgtest.dto.UserDto;
import com.example.webpgtest.entity.User;
import com.example.webpgtest.mapper.Mapper;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class UserToSecurity implements Mapper<User, org.springframework.security.core.userdetails.User> {

    @Override
    public org.springframework.security.core.userdetails.User map(User user) {
        return new org.springframework.security.core.userdetails.User(
                user.getLogin(),
                user.getPassword(),
                Collections.singleton(user.getRole())
        );
    }
}
