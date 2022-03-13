package com.cg.dryclean.service;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dryclean.dao.ICustomerRepository;
import com.cg.dryclean.entity.Customer;
import com.cg.dryclean.exception.RecordNotFoundException;
import com.cg.dryclean.utility.GlobalResources;

@Service("ICustomerService")
public class ICustomerServiceImpl implements ICustomerService {

	@Autowired
	ICustomerRepository iCustomerRepository;
	private Logger logger = GlobalResources.getLogger(ICustomerService.class);

	@Override
	public Customer addCustomer(Customer customer) throws RecordNotFoundException {
		String methodName = "addCustomer()";
		logger.info(methodName + "Called");
		iCustomerRepository.saveAndFlush(customer);
		return customer;
	}

	@Override
	public Customer removeCustomer(int custId) throws RecordNotFoundException {
		String methodName = "removeCustomer()";
		logger.info(methodName + "Called");
		Customer bean = null;
		try {
			bean = iCustomerRepository.findById(custId).get();
		} catch (Exception e) {
			throw new RecordNotFoundException("Customer details not found!");
		}
		iCustomerRepository.deleteById(custId);
		return bean;
	}

	@Override
	public Customer updateCustomer(Customer customer) throws RecordNotFoundException {
		String methodName = "updateCustomer()";
		logger.info(methodName + "Called");
		Customer bean = null;
		try {
			bean = iCustomerRepository.findById(customer.getCustomerId()).get();
		} catch (Exception e) {
			throw new RecordNotFoundException("Customer details not found!");
		}
		iCustomerRepository.saveAndFlush(customer);
		return bean;
	}

	@Override
	public Customer getCustomer(int custId) throws RecordNotFoundException {
		String methodName = "getCustomer()";
		logger.info(methodName + "Called");
		Customer bean = null;
		try {
			bean = iCustomerRepository.findById(custId).get();
		} catch (Exception e) {
			throw new RecordNotFoundException("Customer details not found!");
		}
		return bean;
	}

	@Override
	public List<Customer> getAllCustomers() throws RecordNotFoundException {
		String methodName = "getAllCustomers()";
		logger.info(methodName + "Called");
		return iCustomerRepository.findAll();
	}

}
