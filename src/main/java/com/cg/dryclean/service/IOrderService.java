package com.cg.dryclean.service;

import java.util.List;

import com.cg.dryclean.entity.Order;
import com.cg.dryclean.exception.RecordNotFoundException;

public interface IOrderService {
	public Order addOrder(Order order) throws RecordNotFoundException;

	public Order removeOrder(int id) throws RecordNotFoundException;

	public Order updateOrder(Order order) throws RecordNotFoundException;

	public Order getOrderDetails(int id) throws RecordNotFoundException;

	public List<Order> getAllOrders() throws RecordNotFoundException;

}
