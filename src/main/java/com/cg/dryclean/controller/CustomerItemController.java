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

import com.cg.dryclean.entity.Item;
import com.cg.dryclean.exception.RecordNotFoundException;
import com.cg.dryclean.service.ICustomerItemService;
import com.cg.dryclean.utility.GlobalResources;

@RestController
@RequestMapping("/customeritem")
public class CustomerItemController {

	@Autowired
	ICustomerItemService iCustomerItemService;
	private Logger logger = GlobalResources.getLogger(ICustomerItemService.class);

	@PostMapping("/customeritems")
	public Item addItem(@RequestBody Item item) throws RecordNotFoundException {
		String methodName = "addItem()";
		logger.info(methodName + "Called");
		return iCustomerItemService.addItem(item);
	}

	@DeleteMapping("/customeritem/{id}")
	public Item removeItem(@PathVariable int id) throws RecordNotFoundException {
		String methodName = "removeItem()";
		logger.info(methodName + "Called");
		return iCustomerItemService.removeItem(id);
	}

	@PutMapping("/customeritems")
	public Item updateItem(@RequestBody Item item) throws RecordNotFoundException {
		String methodName = "updateItem()";
		logger.info(methodName + "Called");
		return iCustomerItemService.updateItem(item);
	}

	/*
	 * @GetMapping("/customeritems/{id}") public Item getItem(@PathVariable int id)
	 * throws RecordNotFoundException{ String methodName="getItem()";
	 * logger.info(methodName+"Called"); return iCustomerItemService.getItem(id); }
	 */

	@GetMapping("/customeritems/{Id}")
	public List<Item> getItemsByCustomer(@PathVariable int customerId) throws RecordNotFoundException {
		String methodName = "getItemsByCustomer()";
		logger.info(methodName + "Called");
		return iCustomerItemService.getItemsByCustomer(customerId);
	}

}
