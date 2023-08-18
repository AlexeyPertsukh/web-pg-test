package com.example.webpgtest.mapper.user_mapper;

import com.example.webpgtest.entity.Role;
import com.example.webpgtest.entity.User;
import com.example.webpgtest.dto.UserDto;
import com.example.webpgtest.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class DtoToUserMapper implements Mapper<UserDto, User> {
    @Override
    public User map(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .login(userDto.getLogin())
                .email(userDto.getEmail())
                .role(Role.USER)
                .build();
    }
}
