package com.forkalau.lmsjava.services;

import com.forkalau.lmsjava.domain.Author;
import com.forkalau.lmsjava.domain.Loan;
import com.forkalau.lmsjava.services.iservices.IFactory;
import com.forkalau.lmsjava.services.middlewares.exceptions.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FactoryService implements IFactory {

    @Override
    public Author CreateAuthor () {
        return new Author();
    }
    @Override
    public Loan CreateLoan () {
        return new Loan();
    }
    @Override
    public Date NewDate() { return new Date(); }
    @Override
    public CustomException ThrowException(String message) { return new CustomException(message);}

    @Override
    public ResponseEntity<?> responseEntity(Object body, HttpStatus status) {
        return new ResponseEntity(body, status);
    }

}
