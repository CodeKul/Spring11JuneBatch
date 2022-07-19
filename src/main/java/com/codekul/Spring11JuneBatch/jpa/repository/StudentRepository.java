package com.codekul.Spring11JuneBatch.jpa.repository;

import com.codekul.Spring11JuneBatch.jpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByName(String name);
    List<Student> findByAgeGreaterThan(Integer age);
    //Student findByNameAndCity(String name,String city);
}
