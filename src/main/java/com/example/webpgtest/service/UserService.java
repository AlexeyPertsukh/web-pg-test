package com.example.webpgtest.service;

import com.example.webpgtest.domain.User;
import com.example.webpgtest.dto.UserDto;
import org.hibernate.service.Service;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Iterable<User> findAll();
    Optional<User> findById(long id);
    void deleteById(long id);
    User create(UserDto userDto);

    Optional<UserDto> update(Long id, UserDto userDto);
}
