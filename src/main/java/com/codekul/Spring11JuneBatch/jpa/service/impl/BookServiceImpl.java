package com.codekul.Spring11JuneBatch.jpa.service.impl;

import com.codekul.Spring11JuneBatch.jpa.dto.response.CalculatePagesResponse;
import com.codekul.Spring11JuneBatch.jpa.model.Book;
import com.codekul.Spring11JuneBatch.jpa.repository.BookRepository;
import com.codekul.Spring11JuneBatch.jpa.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Override
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Optional<Book> findBookById(Long bookId) {
        return bookRepository.findById(bookId);
    }

    @Override
    public CalculatePagesResponse calculateNoOfPages(String title) {
        return bookRepository.calculateNoOfPages(title);
    }
}
