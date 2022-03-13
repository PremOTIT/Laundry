package com.cg.dryclean.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dryclean.entity.Payment;
import com.cg.dryclean.exception.RecordNotFoundException;
import com.cg.dryclean.service.IPaymentService;
import com.cg.dryclean.utility.GlobalResources;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	IPaymentService iPaymentService;
	private Logger logger = GlobalResources.getLogger(IPaymentService.class);

	@SuppressWarnings("rawtypes")
	@PostMapping("/payments")
	public ResponseEntity addPayment(@RequestBody Payment payment) throws RecordNotFoundException {
		String methodName = "addPayment()";
		logger.info(methodName + "Called");
		return iPaymentService.addPayment(payment);
	}

	@SuppressWarnings("rawtypes")
	@DeleteMapping("/payments/{id}")
	public ResponseEntity removePayment(@PathVariable int id) throws RecordNotFoundException {
		String methodName = "removePayment()";
		logger.info(methodName + "Called");
		return iPaymentService.removePayment(id);
	}

	@SuppressWarnings("rawtypes")
	@PutMapping("/payments")
	public ResponseEntity updatePayment(@RequestBody Payment payment) throws RecordNotFoundException {
		String methodName = "updatePayment()";
		logger.info(methodName + "Called");
		return iPaymentService.updatePayment(payment);
	}

	@GetMapping("/payments/{id}")
	public Payment getPaymentDetails(@PathVariable int id) throws RecordNotFoundException {
		String methodName = "getPaymentDetails()";
		logger.info(methodName + "Called");
		return iPaymentService.getPaymentDetails(id);
	}

	@GetMapping("/payments")
	public List<Payment> getAllPaymentDetails() throws RecordNotFoundException {
		String methodName = "getAllPaymentDetails()";
		logger.info(methodName + "Called");
		return iPaymentService.getAllPaymentDetails();
	}

}
