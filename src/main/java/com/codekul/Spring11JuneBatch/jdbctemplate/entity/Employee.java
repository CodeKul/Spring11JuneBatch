package com.codekul.Spring11JuneBatch.jdbctemplate.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Long id;
    private String name;
    private String location;
    private String department;

}
/**
 * create database springbootjdbc;
 * use springbootjdbc;
 *
 * create table employee(
 * id INT primary key auto_increment,
 * name varchar(30) not null,location varchar(50)not null,department varchar(30)not null);
 *
 * insert into employee(name,location,department) values('Akshay0','Pune','Sale');
 * insert into employee(name,location,department) values('Namita','Mumbai','Finanace');
 * select * from employee;
 */