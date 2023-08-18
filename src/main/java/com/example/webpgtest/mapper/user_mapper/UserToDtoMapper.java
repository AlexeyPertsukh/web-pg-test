package com.example.webpgtest.mapper.user_mapper;

import com.example.webpgtest.entity.User;
import com.example.webpgtest.dto.UserDto;
import com.example.webpgtest.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class UserToDtoMapper implements Mapper<User, UserDto> {
    @Override
    public UserDto map(User user) {
        return new UserDto(
                user.getId(),
                user.getLogin(),
                user.getEmail());
    }
}
