package com.codekul.Spring11JuneBatch.jpa.repository;

import com.codekul.Spring11JuneBatch.jpa.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book,Long> {
    @Query(value = "select b from books b where b.isbn = ?",nativeQuery = true)
    Book findByIsbn(String isbn);
    /**
     * s
     * select b.title,b.author,b.isbn,sum(p.number)as pages,p.book_id from books b inner join pages p
     * where b.id = p.book_id and b.title = 'CPP' group by p.book_id ;
     */
}
