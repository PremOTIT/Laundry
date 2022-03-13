package com.cg.dryclean.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.dryclean.entity.Payment;
import com.cg.dryclean.exception.RecordNotFoundException;

public interface IPaymentService {
	public ResponseEntity addPayment(Payment payment) throws RecordNotFoundException;

	public ResponseEntity removePayment(int id) throws RecordNotFoundException;

	public ResponseEntity updatePayment(Payment payment) throws RecordNotFoundException;

	public Payment getPaymentDetails(int id) throws RecordNotFoundException;

	public List<Payment> getAllPaymentDetails() throws RecordNotFoundException;
}
