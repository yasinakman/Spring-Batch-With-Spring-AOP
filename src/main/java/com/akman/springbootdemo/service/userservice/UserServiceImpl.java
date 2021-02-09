package com.akman.springbootdemo.service.userservice;

import com.akman.springbootdemo.model.User;
import com.akman.springbootdemo.repository.UserRepository;
import com.akman.springbootdemo.rest_api.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Transactional
    @Override
    public User saveUser() {
        User user = User.builder().firstName("yasin").lastName("akman").email("yasin_akman@hotmail.de").build();
        User save;
        try {
            save = userRepository.saveAndFlush(user);
        } catch (Exception e) {
            throw new BadRequestException("User with following email: '" + user.getEmail() + "' is already existing");
        }
        return save;
    }

    @Override
    public List<User> listUsers() {
        List<User> allUsers = userRepository.findAll();
        userRepository.deleteAll();
        return allUsers;
    }
}