package com.codekul.Spring11JuneBatch.jpa.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
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
    @JsonManagedReference
    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private List<Page> pages;

}

