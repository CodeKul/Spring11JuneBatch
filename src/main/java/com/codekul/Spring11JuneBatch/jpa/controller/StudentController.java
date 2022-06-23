package com.codekul.Spring11JuneBatch.jpa.controller;

import com.codekul.Spring11JuneBatch.jpa.model.Student;
import com.codekul.Spring11JuneBatch.jpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student/")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/saveStudent")
    public String saveStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return "Student saved successfully";
    }

    @GetMapping("/getStudentByName/{name}")
    public List<Student> findStudentByName(@PathVariable String name){
       return studentService.findByName(name);
    }
}
