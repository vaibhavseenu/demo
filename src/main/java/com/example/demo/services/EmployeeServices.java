package com.example.demo.services;

import com.example.demo.entities.Employee;

import java.util.List;

public interface EmployeeServices {

    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees(Employee employee);

    Employee updateEmployee(Employee employee,int id);



}
