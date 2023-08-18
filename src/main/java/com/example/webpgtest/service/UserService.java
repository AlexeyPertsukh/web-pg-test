package com.example.webpgtest.service;

import com.example.webpgtest.entity.User;
import com.example.webpgtest.dto.UserDto;

import java.util.Optional;

public interface UserService {
    Iterable<User> findAll();
    Optional<User> findById(long id);
    void deleteById(long id);
    User create(UserDto userDto);

    Optional<UserDto> update(Long id, UserDto userDto);
}
