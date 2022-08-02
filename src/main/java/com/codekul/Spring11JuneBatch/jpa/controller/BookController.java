package com.codekul.Spring11JuneBatch.jpa.controller;

import com.codekul.Spring11JuneBatch.jpa.dto.response.CalculatePagesResponse;
import com.codekul.Spring11JuneBatch.jpa.model.Book;
import com.codekul.Spring11JuneBatch.jpa.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<?> saveBook(@RequestBody Book book){
        bookService.saveBook(book);
        //HttpStatus
        return ResponseEntity.ok("Book record saved successfully");
    }
   @GetMapping
    public ResponseEntity<?> findBookById(@RequestParam Long bookId){
      return ResponseEntity.ok( bookService.findBookById(bookId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Book with id %d is not found",bookId))));
    }

    @GetMapping("{title}")
    public ResponseEntity<?> calculatePages(@PathVariable String title){
        CalculatePagesResponse response = bookService.calculateNoOfPages(title);
        return ResponseEntity.ok(response);

    }


}
