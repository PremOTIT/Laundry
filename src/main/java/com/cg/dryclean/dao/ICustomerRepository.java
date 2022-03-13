package com.cg.dryclean.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.dryclean.entity.Customer;

@Repository
public interface ICustomerRepository extends ICustomer, JpaRepository<Customer, Integer> {

}
