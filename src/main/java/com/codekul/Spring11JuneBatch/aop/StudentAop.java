package com.codekul.Spring11JuneBatch.aop;

import com.codekul.Spring11JuneBatch.jpa.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.List;

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

    @Around("execution(* com.codekul.Spring11JuneBatch.jpa.controller.StudentController.findStudentByAge(..))")
    public List<Student> findAllStudentAopBeforeAndAfter(ProceedingJoinPoint joinPoint){
        log.info("Inside around find all findStudentByAge");
        log.info("class "+joinPoint.getTarget().getClass().getSimpleName());
        log.info("Method "+joinPoint.getSignature().getName());
        log.info("Args "+joinPoint.getArgs()[0].toString());
        Integer age = Integer.parseInt(joinPoint.getArgs()[0].toString());
        List<Student> students = null;
        try {
            if (age > 18)
            students = ( List<Student>) joinPoint.proceed(); // executes the target method with args & returns the response
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return students;
    }

}
