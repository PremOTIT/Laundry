package com.cg.dryclean.service;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.dryclean.dao.IPaymentRepository;
import com.cg.dryclean.entity.Payment;
import com.cg.dryclean.exception.RecordNotFoundException;
import com.cg.dryclean.utility.GlobalResources;

@Service("IPaymentService")
public class IPaymentServiceImpl implements IPaymentService {

	@Autowired
	IPaymentRepository iPaymentRepository;
	private Logger logger = GlobalResources.getLogger(IPaymentService.class);

	@Override
	public ResponseEntity addPayment(Payment payment) throws RecordNotFoundException {
		String methodName = "addPayment()";
		logger.info(methodName + "Called");
		iPaymentRepository.saveAndFlush(payment);
		return new ResponseEntity("Payment Added successfully!!!", HttpStatus.OK);
	}

	@Override
	public ResponseEntity removePayment(int id) throws RecordNotFoundException {
		String methodName = "removePayment()";
		logger.info(methodName + "Called");
		Payment bean = null;
		try {
			bean = iPaymentRepository.findById(id).get();
		} catch (Exception e) {
			throw new RecordNotFoundException("Payment details not found!");
		}
		iPaymentRepository.deleteById(id);
		return new ResponseEntity("Payment Deleted successfully!!!", HttpStatus.OK);
	}

	@Override
	public ResponseEntity updatePayment(Payment payment) throws RecordNotFoundException {
		String methodName = "updatePayment()";
		logger.info(methodName + "Called");
		Payment bean = null;
		try {
			bean = iPaymentRepository.findById(payment.getPaymentId()).get();
		} catch (Exception e) {
			throw new RecordNotFoundException("Payment details not found!");
		}
		iPaymentRepository.saveAndFlush(payment);
		return new ResponseEntity("Payment Updated successfully!!!", HttpStatus.OK);
	}

	@Override
	public Payment getPaymentDetails(int id) throws RecordNotFoundException {
		String methodName = "getPaymentDetails()";
		logger.info(methodName + "Called");
		Payment bean = null;
		try {
			bean = iPaymentRepository.findById(id).get();
		} catch (Exception e) {
			throw new RecordNotFoundException("Payment details not found!");
		}
		return bean;
	}

	@Override
	public List<Payment> getAllPaymentDetails() throws RecordNotFoundException {
		String methodName = "getAllPaymentDetails()";
		logger.info(methodName + "Called");
		return iPaymentRepository.findAll();
	}

}
