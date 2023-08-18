package com.example.webpgtest.mapper;

import com.example.webpgtest.domain.User;
import com.example.webpgtest.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class DtoToUserMapper implements Mapper<UserDto, User>{
    @Override
    public User map(UserDto userDto) {
        return new User(userDto.getId(), userDto.getLogin(), userDto.getEmail());
    }
}
