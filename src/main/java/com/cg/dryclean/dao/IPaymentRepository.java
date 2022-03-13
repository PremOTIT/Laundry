package com.cg.dryclean.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.dryclean.entity.Payment;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Integer>{

}
