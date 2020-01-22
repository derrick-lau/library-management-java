package com.forkalau.lmsjava.services;


import com.forkalau.lmsjava.domain.Book;
import com.forkalau.lmsjava.domain.Loan;
import com.forkalau.lmsjava.domain.User;
import com.forkalau.lmsjava.repositories.IBookRepository;
import com.forkalau.lmsjava.repositories.ILoanRepository;
import com.forkalau.lmsjava.repositories.IUserRepository;
import com.forkalau.lmsjava.services.middlewares.exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Optional;

public class LoanService {
    @Autowired
    private ILoanRepository loanRepository;

    @Autowired
    private IBookRepository bookRepository;

    @Autowired
    private IUserRepository userRepository;

    public Loan saveOrUpdateLoan (Long bookID, Long userID) {
        try {
            Optional<Book> bookOption = bookRepository.findById(bookID);
            Optional<User> userOption = userRepository.findById(userID);
            if (bookOption != null && userOption != null) {
                Book book = bookOption.get();
                User user = userOption.get();
                Date dueDate = new Date();
                Loan loan = new Loan(dueDate, user, book);
                return loanRepository.save(loan);
            } else {
                return null;
            }
        } catch (Exception e) {throw new CustomException("Loan BookID:" + bookID + ", UserId: " + userID + " already exist");}
    }


}
