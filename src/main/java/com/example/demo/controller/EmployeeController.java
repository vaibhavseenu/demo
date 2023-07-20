package com.example.demo.controller;

import com.example.demo.entities.Employee;
import com.example.demo.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apis")
public class EmployeeController {

    @Autowired
    EmployeeServices services;

    @PostMapping("/post")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(services.saveEmployee(employee), HttpStatus.ACCEPTED);
    }

    @GetMapping("/get")
    public List<Employee> getAllEmployees(Employee employee){
        return services.getAllEmployees(employee);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id")int id,@RequestBody Employee employee){
        return new ResponseEntity<Employee>(services.updateEmployee(employee,id),HttpStatus.ACCEPTED);
    }
}
