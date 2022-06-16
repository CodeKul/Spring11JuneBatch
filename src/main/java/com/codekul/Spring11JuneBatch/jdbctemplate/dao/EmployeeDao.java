package com.codekul.Spring11JuneBatch.jdbctemplate.dao;

import com.codekul.Spring11JuneBatch.jdbctemplate.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    String save(Employee e);
    List<Employee> findAll();
}
