package com.forkalau.lmsjava.services;

import com.forkalau.lmsjava.domain.User;
import com.forkalau.lmsjava.services.middlewares.exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.forkalau.lmsjava.repositories.IUserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    public List<User> findAllContainBarcodeOrName(String barcode, String name) {
        List<User> userList = userRepository.findAll();
        userList = filterUserList(barcode, name, userList);
        return userList;
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

    public List<User> filterUserList (String barcode, String name, List<User> userList) {
        List<User> filterUserList = userList.stream()
                .map(user ->  user.getBarcode().contains(barcode) || user.getName().contains(name)? user:null)
                .filter(user -> user != null)
                .collect(Collectors.toList());
        return filterUserList;
    }


}
