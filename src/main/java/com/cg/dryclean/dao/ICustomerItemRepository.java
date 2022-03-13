package com.cg.dryclean.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.dryclean.entity.Item;

@Repository
public interface ICustomerItemRepository extends ICustomerItem, JpaRepository<Item, Integer> {

}
