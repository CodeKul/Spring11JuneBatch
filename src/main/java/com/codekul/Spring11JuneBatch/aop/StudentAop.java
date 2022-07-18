package com.codekul.Spring11JuneBatch.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class StudentAop {
    @Before( "execution(* com.codekul.Spring11JuneBatch.jpa.controller.StudentController.findAllStudent(..))")
    public void findAllStudentAopBefore(){
      log.info("Inside before find all students");
    }

    @After( "execution(* com.codekul.Spring11JuneBatch.jpa.controller.StudentController.findAllStudent(..))")
    public void findAllStudentAopAfter(){
        log.info("Inside after find all students");
    }

    @Before( "execution(* com.codekul.Spring11JuneBatch.jpa.controller.StudentController.findStudentByName(..)) && args(name)" )
    public void findStudentByName(String name){
        log.info("Executing find student by name method "+name);
    }
}
