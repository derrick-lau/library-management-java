package com.forkalau.lmsjava.services;

import com.forkalau.lmsjava.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.forkalau.lmsjava.repositories.IUserRepository;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    public User saveOrUpdateUser(User user) {

        // Business logic

        return userRepository.save(user);
    }
}
