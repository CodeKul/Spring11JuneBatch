package com.codekul.Spring11JuneBatch.jdbctemplate.controller;

import com.codekul.Spring11JuneBatch.jdbctemplate.dao.EmployeeDao;
import com.codekul.Spring11JuneBatch.jdbctemplate.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @PostMapping("/saveEmployee")
    public String saveEmployee(@RequestBody Employee employee){
       String msg = employeeDao.save(employee);
       return msg;
    }

    @GetMapping("/findAll")
    public List<Employee> getAllEmployee(){
        return employeeDao.findAll();
    }

    @GetMapping("/findById/{userId}")
    public Employee findById(@PathVariable Long userId){
        return employeeDao.findById(userId);
    }
}
