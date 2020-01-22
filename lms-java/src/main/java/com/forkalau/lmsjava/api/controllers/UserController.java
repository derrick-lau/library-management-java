package com.forkalau.lmsjava.api.controllers;

import com.forkalau.lmsjava.domain.User;
import com.forkalau.lmsjava.services.MapValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.forkalau.lmsjava.services.UserService;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MapValidationError mapValidationError;

    @GetMapping("/search")
    public ResponseEntity<List<User>> getUserByBarcodeOrName(@RequestParam String barcode, String name) {
        List<User> userList= userService.findAllContainBarcodeOrName(barcode, name);
        return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> createNewUser(@Valid @RequestBody User user, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidationError.mapValidationError(result);
        if (errorMap != null) return errorMap;

        User user1 = userService.saveOrUpdateUser(user);
        return new ResponseEntity<User>(user1, HttpStatus.CREATED);
    }


    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestParam Long id, String barcode) {
        userService.deleteUserByIdAndBarcode(id, barcode);
        return new ResponseEntity<String>("User with ID:'" + id + "'was deleted.", HttpStatus.OK);
    }
}
