package com.forkalau.lmsjava.services.iservices;

import com.forkalau.lmsjava.domain.Author;
import com.forkalau.lmsjava.domain.Loan;
import com.forkalau.lmsjava.services.middlewares.exceptions.CustomException;
import com.forkalau.lmsjava.services.middlewares.exceptions.InvalidLoginResponse;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

public interface IFactory {
    Author CreateAuthor ();
    Loan CreateLoan ();
    Date NewDate ();
    CustomException ThrowException (String message);
    ResponseEntity responseEntity(Object body, HttpStatus status);
    InvalidLoginResponse invalidLoginResponse();
    Gson gson();
    BCryptPasswordEncoder bcryptPasswordEncoder();
    UsernameNotFoundException usernameNotFoundException(String ex);
}
