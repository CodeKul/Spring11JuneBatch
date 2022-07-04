package com.codekul.Spring11JuneBatch.jpa.model;

import javax.persistence.*;

@Entity
@Table(name = "pages")
public class Page {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer number;
    private String content;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
