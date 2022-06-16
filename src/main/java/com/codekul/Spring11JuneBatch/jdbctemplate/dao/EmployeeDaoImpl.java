package com.codekul.Spring11JuneBatch.jdbctemplate.dao;

import com.codekul.Spring11JuneBatch.jdbctemplate.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDaoImpl implements EmployeeDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    String insertQuery = "Insert into employee(name,location,department) values(?,?,?)";
    String findAll = "select * from employee";
    @Override
    public String save(Employee e) {
        jdbcTemplate.update(insertQuery,new Object[]{e.getName(),e.getLocation(),e.getDepartment()});
        return "Data saved successfully";
    }

    @Override
    public List<Employee> findAll() {
        return jdbcTemplate.query("select * from employee",new BeanPropertyRowMapper<Employee>(Employee.class));
    }
}
