package com.example.webpgtest.service;

import com.example.webpgtest.entity.User;
import com.example.webpgtest.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {
    Iterable<User> findAll();
    Optional<User> findById(long id);
    void deleteById(long id);
    User create(UserDto userDto);

    Optional<UserDto> update(Long id, UserDto userDto);
}
