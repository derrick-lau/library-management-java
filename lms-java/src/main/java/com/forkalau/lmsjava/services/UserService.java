package com.forkalau.lmsjava.services;

import com.forkalau.lmsjava.domain.User;
import com.forkalau.lmsjava.services.middlewares.exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.forkalau.lmsjava.repositories.IUserRepository;

import java.util.Set;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    public Set<User> findAllContainingBarcodeOrName(String barcode, String name) {
        Set<User> userSet = userRepository.findByBarcodeContainingOrNameContaining(barcode, name);
        return userSet;
    }

    public User saveOrUpdateUser(User user) {
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            throw new CustomException("User barcode: '" + user.getBarcode() + "' already exist");
        }
    }

    public void deleteUserByIdAndBarcode (Long id, String barcode) {
        User user = userRepository.findByBarcode(barcode);
        if (user == null || user.getId() != id)
            throw new CustomException("Cannot find user.");
        userRepository.delete(user);
    }
}
