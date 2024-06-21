package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

	
    public Employee findByEmail(String email);

    // select password from employee where email=?
    @Query("select password from Employee where email=:email")
    public String findPasswordByEmployeeEmail(String email);

}
