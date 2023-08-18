package com.example.webpgtest.service.impl;

import com.example.webpgtest.entity.User;
import com.example.webpgtest.dto.UserDto;
import com.example.webpgtest.mapper.user_mapper.DtoToUserMapper;
import com.example.webpgtest.mapper.user_mapper.UserToDtoMapper;
import com.example.webpgtest.mapper.user_mapper.UserToSecurity;
import com.example.webpgtest.repository.UserRepository;
import com.example.webpgtest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserToDtoMapper userToDtoMapper;
    private final DtoToUserMapper dtoToUserMapper;
    private final UserToSecurity userToSecurityMapper;

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
        String password = optionalUser.get().getPassword();
        User user = dtoToUserMapper.map(userDto);
        user.setPassword(password);
        userRepository.delete(optionalUser.get());
        User newUser = userRepository.saveAndFlush(user);
        UserDto dto = userToDtoMapper.map(newUser);
        return Optional.of(dto);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> optionalUser = userRepository.findByLogin(username);
        if(optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("failed to retrieve username: " + username);
        }
        User user = optionalUser.get();
        return userToSecurityMapper.map(user);
    }
}
