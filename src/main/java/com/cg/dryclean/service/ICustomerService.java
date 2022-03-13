package com.cg.dryclean.service;

import java.util.List;

import com.cg.dryclean.entity.Customer;
import com.cg.dryclean.exception.RecordNotFoundException;

public interface ICustomerService {
	public Customer addCustomer(Customer customer) throws RecordNotFoundException;

	public Customer removeCustomer(int custId) throws RecordNotFoundException;

	public Customer updateCustomer(Customer customer) throws RecordNotFoundException;

	public Customer getCustomer(int custId) throws RecordNotFoundException;

	public List<Customer> getAllCustomers() throws RecordNotFoundException;
}
