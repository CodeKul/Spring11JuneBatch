package com.codekul.Spring11JuneBatch.di;

import org.springframework.stereotype.Component;

@Component
public class Student {
    private Integer id;
    private String sname;

    public Student() {
        System.out.println("in student constructor");
    }
    public void display(){
        System.out.println("in display method");
    }
}
