package com.codekul.Spring11JuneBatch.jpa.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class StudentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String bloodGroup;
    @OneToOne
    @JsonBackReference
    @JoinColumn(name = "student_id")
    private Student student;
}
