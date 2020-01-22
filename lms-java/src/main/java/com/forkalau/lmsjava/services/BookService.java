package com.forkalau.lmsjava.services;

import com.forkalau.lmsjava.domain.Author;
import com.forkalau.lmsjava.domain.Book;
import com.forkalau.lmsjava.domain.User;
import com.forkalau.lmsjava.repositories.IAuthorRepository;
import com.forkalau.lmsjava.repositories.IBookRepository;
import com.forkalau.lmsjava.services.middlewares.exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.forkalau.lmsjava.repositories.IUserRepository;

import java.util.Set;

@Service
public class BookService {

    @Autowired
    private IBookRepository bookRepository;

    @Autowired
    private IAuthorRepository authorRepository;

    public Book saveOrUpdateBook(Book book, String authors) {
        try {

            return bookRepository.save(book);
        } catch (Exception e) {
            throw new CustomException("Book ISBN: '" + book.getIsbn() + "' already exist");
        }
    }

}
