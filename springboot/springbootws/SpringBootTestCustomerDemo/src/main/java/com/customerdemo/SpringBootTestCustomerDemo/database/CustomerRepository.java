package com.customerdemo.SpringBootTestCustomerDemo.database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.customerdemo.SpringBootTestCustomerDemo.beans.Customer;



@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>{

}
