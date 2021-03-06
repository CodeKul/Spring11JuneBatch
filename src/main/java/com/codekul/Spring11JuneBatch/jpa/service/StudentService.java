package com.codekul.Spring11JuneBatch.jpa.service;

import com.codekul.Spring11JuneBatch.jpa.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> findByName(String nm);

    List<Student> findByAgeGreaterThan(Integer age);

    void saveStudent(Student student);
    void deleteById(Long id);

    List<Student> findAllStudents();

    void saveAllStudent(List<Student> students);
}
