package com.codekul.Spring11JuneBatch.jpa.model;

import javax.persistence.*;
import java.util.List;

@Entity
 public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;

    @ManyToMany(mappedBy = "courses",cascade = CascadeType.ALL)
    private List<Student> students;
}
