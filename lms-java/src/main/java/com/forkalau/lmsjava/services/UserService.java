package com.forkalau.lmsjava.services;

import com.forkalau.lmsjava.services.middlewares.exceptions.CustomException;
import com.forkalau.lmsjava.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.forkalau.lmsjava.repositories.IUserRepository;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    public User saveOrUpdateUser(User user) {
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            throw new CustomException("Barcode'" + user.getBarcode() + " already exist");
        }
    }
}
