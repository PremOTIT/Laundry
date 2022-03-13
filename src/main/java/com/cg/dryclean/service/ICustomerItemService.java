package com.cg.dryclean.service;

import java.util.List;

import com.cg.dryclean.entity.Item;
import com.cg.dryclean.exception.RecordNotFoundException;

public interface ICustomerItemService {
	public Item addItem(Item item) throws RecordNotFoundException;

	public Item removeItem(int id) throws RecordNotFoundException;

	public Item updateItem(Item item) throws RecordNotFoundException;

	public Item getItem(int id) throws RecordNotFoundException;

	public List<Item> getItemsByCustomer(int customerId) throws RecordNotFoundException;
}
