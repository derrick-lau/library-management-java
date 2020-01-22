package com.forkalau.lmsjava.repositories;

import com.forkalau.lmsjava.domain.Book;
import com.forkalau.lmsjava.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;


@Repository
public interface IBookRepository extends CrudRepository<Book, Long> {

    Set<Book>  findByTitleContaining(String title);

}