package com.codekul.Spring11JuneBatch.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class School {

    @Autowired
    private Student student;

    //setter based injection
    public void setStudent(Student student){
        this.student = student;
    }

    //constructor based injection
    public School(Student student){
        this.student = student;
    }

    public void show(){
        student.display();
    }
}
