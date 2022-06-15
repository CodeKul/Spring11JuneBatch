package com.codekul.Spring11JuneBatch.jdbctemplate.dao;

import com.codekul.Spring11JuneBatch.jdbctemplate.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    String insertQuery = "Insert into employee(name,location,department) values(?,?,?)";
    String findAll = "Select * from employee";
    @Override
    public void save(Employee e) {
        jdbcTemplate.update(insertQuery,new Object[]{e.getName(),e.getLocation(),e.getDepartment()});
    }

    @Override
    public List<Employee> findAll() {
        return jdbcTemplate.query(findAll,new BeanPropertyRowMapper<>(Employee.class));
    }
}
