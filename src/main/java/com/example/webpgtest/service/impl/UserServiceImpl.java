package com.example.webpgtest.service.impl;

import com.example.webpgtest.domain.User;
import com.example.webpgtest.dto.UserDto;
import com.example.webpgtest.mapper.DtoToUserMapper;
import com.example.webpgtest.mapper.UserToDtoMapper;
import com.example.webpgtest.repository.UserRepository;
import com.example.webpgtest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserToDtoMapper userToDtoMapper;
    private final DtoToUserMapper dtoToUserMapper;

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User create(UserDto userDto) {
        User user = dtoToUserMapper.map(userDto);
        return userRepository.save(user);
    }

    @Override
    public Optional<UserDto> update(Long id, UserDto userDto) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            return Optional.empty();
        }
        User user = dtoToUserMapper.map(userDto);
        userRepository.delete(optionalUser.get());
        User newUser = userRepository.saveAndFlush(user);
        UserDto dto = userToDtoMapper.map(newUser);
        return Optional.of(dto);
    }
}
