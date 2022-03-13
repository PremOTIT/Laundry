package com.cg.dryclean.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dryclean.entity.Customer;
import com.cg.dryclean.exception.RecordNotFoundException;
import com.cg.dryclean.service.ICustomerService;
import com.cg.dryclean.utility.GlobalResources;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	ICustomerService iCustomerService;
	private Logger logger = GlobalResources.getLogger(ICustomerService.class);

	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) throws RecordNotFoundException {
		String methodName = "addCustomer()";
		logger.info(methodName + "Called");
		return iCustomerService.addCustomer(customer);
	}

	@DeleteMapping("/customer/{Id}")
	public Customer removeCustomer(@PathVariable int Id) throws RecordNotFoundException {
		String methodName = "removeCustomer()";
		logger.info(methodName + "Called");
		return iCustomerService.removeCustomer(Id);
	}

	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer) throws RecordNotFoundException {
		String methodName = "updateCustomer()";
		logger.info(methodName + "Called");
		return iCustomerService.updateCustomer(customer);
	}

	@GetMapping("/customers/{Id}")
	public Customer getCustomer(@PathVariable int Id) throws RecordNotFoundException {
		String methodName = "getCustomer()";
		logger.info(methodName + "Called");
		return iCustomerService.getCustomer(Id);
	}

	@GetMapping("/customers")
	public List<Customer> getAllCustomers() throws RecordNotFoundException {
		String methodName = "getAllCustomers()";
		logger.info(methodName + "Called");
		return iCustomerService.getAllCustomers();

	}

}
