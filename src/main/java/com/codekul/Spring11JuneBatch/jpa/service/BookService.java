package com.codekul.Spring11JuneBatch.jpa.service;

import com.codekul.Spring11JuneBatch.jpa.dto.response.CalculatePagesResponse;
import com.codekul.Spring11JuneBatch.jpa.model.Book;

import java.util.Optional;

public interface BookService {
    void saveBook(Book book);
    Optional<Book> findBookById(Long bookId);
    CalculatePagesResponse calculateNoOfPages(String title);
}
