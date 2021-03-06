package com.codekul.Spring11JuneBatch.jpa.service.impl;

import com.codekul.Spring11JuneBatch.jpa.model.Student;
import com.codekul.Spring11JuneBatch.jpa.repository.StudentRepository;
import com.codekul.Spring11JuneBatch.jpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findByName(String name) {
      // String s  = "select * from student s where s.name = ?";
        return studentRepository.findByName(name);
    }

    @Override
    public List<Student> findByAgeGreaterThan(Integer age) {
        return studentRepository.findByAgeGreaterThan(age);
    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void saveAllStudent(List<Student> students) {
        studentRepository.saveAll(students);
    }
}
