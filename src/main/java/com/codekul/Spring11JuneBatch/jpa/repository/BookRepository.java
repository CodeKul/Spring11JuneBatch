package com.codekul.Spring11JuneBatch.jpa.repository;

import com.codekul.Spring11JuneBatch.jpa.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
