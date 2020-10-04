package com.example.kadry2.repsitory;

import com.example.kadry2.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeReposytory extends JpaRepository<Employee,Long> {

    List<Employee> findByFirstAndLastName(String firstName, String lastName);
}
