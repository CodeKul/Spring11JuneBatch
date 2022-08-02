package com.codekul.Spring11JuneBatch.jpa.controller;

import com.codekul.Spring11JuneBatch.jpa.model.Student;
import com.codekul.Spring11JuneBatch.jpa.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/student/")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/saveStudent")
    public String saveStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return "Student saved successfully";
    }

    @PostMapping("/saveAllStudent")
    public String saveAllStudent(@RequestBody List<Student> student){
        studentService.saveAllStudent(student);
        return "Student saved successfully";
    }

    @GetMapping("/getStudentByName/{name}")
    public List<Student> findStudentByName(@PathVariable String name){
       return studentService.findByName(name);
    }

    @DeleteMapping("/deleteById")
    public String deleteStudentById(@RequestParam Long id,@RequestParam String name){
        studentService.deleteById(id);
        return "Record deleted successfully";
    }
    @GetMapping("/findAllStudent")
    public List<Student> findAllStudent(){
        log.info("in find all student method");
        return studentService.findAllStudents();
    }

    @GetMapping("/findStudentByAge")
    public List<Student> findStudentByAge(@RequestParam Integer age){
        log.info("in find Student By Age method");
        return studentService.findByAgeGreaterThan(20);
    }
}
