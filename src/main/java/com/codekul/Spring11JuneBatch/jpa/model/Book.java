package com.codekul.Spring11JuneBatch.jpa.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    private String author;

    @Column(unique = true)
    private String isbn;
    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private List<Page> pages;

}
