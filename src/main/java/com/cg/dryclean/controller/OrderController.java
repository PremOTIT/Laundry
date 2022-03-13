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

import com.cg.dryclean.entity.Order;
import com.cg.dryclean.exception.RecordNotFoundException;
import com.cg.dryclean.service.IOrderService;
import com.cg.dryclean.utility.GlobalResources;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	IOrderService iOrderService;
	private Logger logger = GlobalResources.getLogger(IOrderService.class);

	@PostMapping("/orders")
	public Order addOrder(@RequestBody Order order) throws RecordNotFoundException {
		String methodName = "addOrder()";
		logger.info(methodName + "Called");
		return iOrderService.addOrder(order);
	}

	@DeleteMapping("/order/{id}")
	public Order removeOrder(@PathVariable int id) throws RecordNotFoundException {
		String methodName = "removeOrder()";
		logger.info(methodName + "Called");
		return iOrderService.removeOrder(id);
	}

	@PutMapping("/orders")
	public Order updateOrder(@RequestBody Order order) throws RecordNotFoundException {
		String methodName = "updateOrder()";
		logger.info(methodName + "Called");
		return iOrderService.updateOrder(order);
	}

	@GetMapping("/orders/{id}")
	public Order getOrderDetails(@PathVariable int id) throws RecordNotFoundException {
		String methodName = "getOrderDetails()";
		logger.info(methodName + "Called");
		return iOrderService.getOrderDetails(id);
	}

	@GetMapping("/orders")
	public List<Order> getAllOrders() throws RecordNotFoundException {
		String methodName = "getAllOrders()";
		logger.info(methodName + "Called");
		return iOrderService.getAllOrders();

	}

}
