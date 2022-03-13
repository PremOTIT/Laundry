package com.cg.dryclean.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dryclean.dao.ICustomerItemRepository;
import com.cg.dryclean.dao.ICustomerRepository;
import com.cg.dryclean.entity.Item;
import com.cg.dryclean.exception.RecordNotFoundException;
import com.cg.dryclean.utility.GlobalResources;

@Service("ICustomerItemService")
public class ICustomerItemServiceImpl implements ICustomerItemService {

	@Autowired
	ICustomerItemRepository iCustomerItemRepository;
	private Logger logger = GlobalResources.getLogger(ICustomerItemRepository.class);

	@Autowired
	ICustomerRepository iCustomerRepository;

	@Override
	public Item addItem(Item item) throws RecordNotFoundException {
		String methodName = "addItem()";
		logger.info(methodName + "Called");
		iCustomerItemRepository.saveAndFlush(item);
		return item;
	}

	@Override
	public Item removeItem(int id) throws RecordNotFoundException {
		String methodName = "removeItem()";
		logger.info(methodName + "Called");
		Item bean = null;
		try {
			bean = iCustomerItemRepository.findById(id).get();
		} catch (Exception e) {
			throw new RecordNotFoundException("Item details not found!");
		}
		iCustomerItemRepository.deleteById(id);
		return bean;
	}

	@Override
	public Item updateItem(Item item) throws RecordNotFoundException {
		String methodName = "updateItem()";
		logger.info(methodName + "Called");
		Item bean = null;
		try {
			bean = iCustomerItemRepository.findById(item.getItemId()).get();
		} catch (Exception e) {
			throw new RecordNotFoundException("Item details not found!");
		}
		iCustomerItemRepository.saveAndFlush(item);
		return bean;
	}

	@Override
	public Item getItem(int id) throws RecordNotFoundException {
		String methodName = "getItem()";
		logger.info(methodName + "Called");
		Item bean = null;
		try {
			bean = iCustomerItemRepository.findById(id).get();
		} catch (Exception e) {
			throw new RecordNotFoundException("Item details not found!");
		}
		return bean;
	}

	@Override
	public List<Item> getItemsByCustomer(int customerId) throws RecordNotFoundException {
		String methodName = "getItemsByCustomer()";
		logger.info(methodName + "Called");
		List<Item> items = new ArrayList<>();
		try {
			items = iCustomerRepository.findById(customerId).get().getItems();
		} catch (Exception e) {
			throw new RecordNotFoundException("Item details not found!");
		}
		return items;
	}

}
