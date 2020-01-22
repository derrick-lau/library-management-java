package com.forkalau.lmsjava.api.controllers;

import com.forkalau.lmsjava.domain.Author;
import com.forkalau.lmsjava.domain.Book;
import com.forkalau.lmsjava.domain.User;
import com.forkalau.lmsjava.services.BookService;
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
import java.util.Set;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private MapValidationError mapValidationError;

    @GetMapping("/search")
//    public ResponseEntity<Set<Book>> getBookTitleOrAuthors(@RequestParam String title) {
//
//        Set<Book> bookSet= bookService.findAllContainingTitleOrAuthors(title);
//        return new ResponseEntity(bookSet, HttpStatus.OK);
//    }

    @PostMapping("/add")
    public ResponseEntity<?> createNewBook(@Valid @RequestBody Book book, String authors, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidationError.mapValidationError(result);
        if (errorMap != null) return errorMap;

        Book book1 = bookService.saveOrUpdateBook(book, authors);
        return new ResponseEntity<Book>(book1, HttpStatus.CREATED);
    }


//    @DeleteMapping("/delete")
//    public ResponseEntity<String> deleteUser(@RequestParam Long id, String barcode) {
//        userService.deleteUserByIdAndBarcode(id, barcode);
//        return new ResponseEntity<String>("User with ID:'" + id + "'was deleted.", HttpStatus.OK);
//    }
}
