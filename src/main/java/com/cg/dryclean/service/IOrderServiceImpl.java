package com.cg.dryclean.service;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dryclean.dao.IOrderRepository;
import com.cg.dryclean.entity.Order;
import com.cg.dryclean.exception.RecordNotFoundException;
import com.cg.dryclean.utility.GlobalResources;

@Service("IOrderService")
public class IOrderServiceImpl implements IOrderService {

	@Autowired
	IOrderRepository iOrderRepository;
	private Logger logger = GlobalResources.getLogger(IOrderService.class);

	@Override
	public Order addOrder(Order order) throws RecordNotFoundException {
		String methodName = "addOrder()";
		logger.info(methodName + "Called");
		iOrderRepository.saveAndFlush(order);
		return order;
	}

	@Override
	public Order removeOrder(int id) throws RecordNotFoundException {
		String methodName = "removeOrder()";
		logger.info(methodName + "Called");
		Order bean = null;
		try {
			bean = iOrderRepository.findById(id).get();
		} catch (Exception e) {
			throw new RecordNotFoundException("Order details not found!");
		}
		iOrderRepository.deleteById(id);
		return bean;
	}

	@Override
	public Order updateOrder(Order order) throws RecordNotFoundException {
		String methodName = "updateOrder()";
		logger.info(methodName + "Called");
		Order bean = null;
		try {
			bean = iOrderRepository.findById(order.getOrderId()).get();
		} catch (Exception e) {
			throw new RecordNotFoundException("Order details not found!");
		}
		iOrderRepository.saveAndFlush(order);
		return bean;
	}

	@Override
	public Order getOrderDetails(int id) throws RecordNotFoundException {
		String methodName = "getOrderDetails()";
		logger.info(methodName + "Called");
		Order bean = null;
		try {
			bean = iOrderRepository.findById(id).get();
		} catch (Exception e) {
			throw new RecordNotFoundException("Order details not found!");
		}
		return bean;
	}

	@Override
	public List<Order> getAllOrders() throws RecordNotFoundException {
		String methodName = "getAllOrders()";
		logger.info(methodName + "Called");
		return iOrderRepository.findAll();
	}

}
