package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Employee;
import com.example.demo.exception.InvalidCredentialsException;
import com.example.demo.repo.EmployeeRepo;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepository;


    public EmployeeService() {
        System.out.println("emp service");
    }
    public Employee insertEmployee(Employee employee) {
        if (! employeeRepository.existsById(employee.getEid())) {
            Employee savedEmployee = this.employeeRepository.save(employee);
            return savedEmployee;
        }
        throw new EntityExistsException("Employee with id "+employee.getEid()+" already exists, hence cannot save");
    }


    public Employee findEmployeeByEmail(String email){
        return this.employeeRepository.findByEmail(email);
    }

    public Employee getEmployeeById(int eid) {
        System.out.println("Emp service "+eid);
        return this.employeeRepository
                .findById(eid)
            
                .orElseThrow(()->
                new EntityNotFoundException("Employee "+eid+" not found"));
    }

    public List<Employee> getEmployees(){
        //List<Employee> employees = new ArrayList<Employee>();
        return this.employeeRepository.findAll();//.forEach(employees::add);
        //return employees;
    }

    public Page<Employee> getFilteredEmployees(Integer pageno, Integer size){

        Pageable pageable = PageRequest.of(pageno, size, Sort.by(Sort.Direction.DESC, "email"));
        List<Employee> employees = new ArrayList<Employee>();
        
        Page<Employee> page= this.employeeRepository.findAll(pageable);
        
        return page;

    }

    public Employee updateEmployee(Employee employee) {
        if(!this.employeeRepository.existsById(employee.getEid()))
            throw new EntityNotFoundException("Employee "+employee.getEid()+" not found and cannot be updated");
        return this.employeeRepository.save(employee);
    }

    @Transactional
    public boolean deleteEmployee(int eid) {
        if(!this.employeeRepository.existsById(eid))
            throw new EntityNotFoundException("Employee "+eid+" not found and cannot be deleted");
        this.employeeRepository.deleteById(eid);
        return true;
    }

    public boolean loginEmployee(String email, String password) throws InvalidCredentialsException
    {

        String pwd = this.employeeRepository.findPasswordByEmployeeEmail(email);
        if(pwd!=null)
        {
            if(pwd.equals(password))
                return true;
        }
        throw new InvalidCredentialsException("Invalid credentials, Please try again");
    }
}

