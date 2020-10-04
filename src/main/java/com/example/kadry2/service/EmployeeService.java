package com.example.kadry2.service;

import com.example.kadry2.model.Employee;
import com.example.kadry2.repsitory.EmployeeReposytory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {


    EmployeeReposytory reposytory;


    public EmployeeService(EmployeeReposytory reposytory) {
        this.reposytory = reposytory;
    }

    public void addEmployee(Employee employee) {
        reposytory.save(employee);
    }

    public List<Employee> findAll() {
        return reposytory.findAll();
    }

    public List<Employee> findByFirstAndLastName(String firstName, String lastName) {
        return reposytory.findByFirstAndLastName(firstName, lastName);
    }
}
