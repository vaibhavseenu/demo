package com.example.demo.serviceImpl;

import com.example.demo.entities.Employee;
import com.example.demo.exceptions.ResourceNotFound;
import com.example.demo.repositories.EmployeeRespository;
import com.example.demo.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeServices {
    @Autowired
    public EmployeeRespository repo;

    @Override
    public Employee saveEmployee(Employee employee) {
        return repo.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees(Employee employee) {
        return repo.findAll();
    }

    @Override
    public Employee updateEmployee(Employee employee, int id) {
        Employee em = repo.findById(id).orElseThrow(()->new ResourceNotFound("Employee","Id",id));
        em.setName(employee.getName());
        em.setDepartment(employee.getDepartment());
        repo.save(em);
        return em;
    }
}
