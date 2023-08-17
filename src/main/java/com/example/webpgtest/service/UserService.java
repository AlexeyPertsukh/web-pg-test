package com.example.webpgtest.service;

import com.example.webpgtest.domain.User;
import org.hibernate.service.Service;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Iterable<User> findAll();
    Optional<User> findById(long id);
    void deleteById(long id);
    User create(User user);

    Optional<User> update(Long id, User user);
}
