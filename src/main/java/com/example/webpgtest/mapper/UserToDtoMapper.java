package com.example.webpgtest.mapper;

import com.example.webpgtest.domain.User;
import com.example.webpgtest.dto.UserDto;
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
