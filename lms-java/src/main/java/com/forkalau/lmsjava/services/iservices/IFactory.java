package com.forkalau.lmsjava.services.iservices;

import com.forkalau.lmsjava.domain.Author;
import com.forkalau.lmsjava.domain.Loan;
import com.forkalau.lmsjava.services.middlewares.exceptions.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;

public interface IFactory {
    Author CreateAuthor ();
    Loan CreateLoan ();
    Date NewDate ();
    CustomException ThrowException (String message);
    ResponseEntity responseEntity(Object body, HttpStatus status);
}
