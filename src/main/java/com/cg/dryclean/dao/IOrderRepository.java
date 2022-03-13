package com.cg.dryclean.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.dryclean.entity.Order;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Integer> {

}
