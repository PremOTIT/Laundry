package com.cg.dryclean.services;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.cg.dryclean.dao.IPaymentRepository;
import com.cg.dryclean.entity.Card;
import com.cg.dryclean.entity.Payment;
import com.cg.dryclean.exception.RecordNotFoundException;
import com.cg.dryclean.service.IPaymentServiceImpl;

class TestIPaymentService {

	@Mock
	IPaymentRepository paymentRepository;
	@InjectMocks
	IPaymentServiceImpl service;
	Payment payment;
	@BeforeEach
	public void testCommon() {
		MockitoAnnotations.initMocks(this);
		List<Payment> pay=new ArrayList<>();
		Card c = new Card(11,"Debit","376",LocalDate.now(),737,pay);		
		pay.add(new Payment(2, "NetBanking", "Fail", c));
		payment=new Payment(1, "UPI", "Success", c);
	}

	@Test
	public void testAddPayment() throws RecordNotFoundException {
		Mockito.when(paymentRepository.save(payment)).thenReturn(payment);
		//String actualResult=service.addPayment(payment);
		String expectedResult="Inserted Successfully!!!";
		assertEquals(expectedResult, service.addPayment(payment));
		Mockito.verify(paymentRepository,Mockito.times(1)).save(payment);
	}

	@Test
	public void testUpdatePayment() throws RecordNotFoundException {
		Mockito.when(paymentRepository.save(payment)).thenReturn(payment);
		//String actualResult=service.updatePayment(payment);
		String expectedResult="Updated Successfully!!!";
		assertEquals(expectedResult,service.updatePayment(payment));
		Mockito.verify(paymentRepository,Mockito.times(1)).save(payment);
	}

	@Test
	public void testRemovePayment() throws RecordNotFoundException{
		int id= 1;
		Mockito.when(paymentRepository.findById(id)).thenReturn(Optional.of(payment));
		String expectedResult="Deleted Successfully!!!";
		assertEquals(expectedResult,service.removePayment(id));
		//assertThrows(IdNotFoundException.class, ()->service.removePayment(id));
		Mockito.verify(paymentRepository,Mockito.times(1)).deleteById(id);
	}

	@Test
	public void TestgetPaymentDetails() throws RecordNotFoundException {
		int id =1;
		Mockito.when(paymentRepository.findById(id)).thenReturn(Optional.of(payment));
		Payment expectedResult=service.getPaymentDetails(id);
		assertEquals(expectedResult, payment);
		Mockito.verify(paymentRepository,Mockito.times(1)).findById(id);
	}

	@Test
	public void testgetAllPaymentDetails() throws RecordNotFoundException {
		int Id= 1;
		List<Payment> pay=new ArrayList<>();
		Card c1= new Card(211,"Credit","432",LocalDate.now(),2332,pay);
		Card c2=new Card(311,"Debit","654",LocalDate.now(),5534,pay);
		Card c3=new Card(411,"Credit","33733",LocalDate.now(),299,pay);
		pay.add(new Payment(2, "NetBanking", "Fail", c1));
		pay.add(new Payment(3, "Card", "Fail", c2));
		pay.add(new Payment(4, "Cash", "Success", c3));

		Mockito.when(paymentRepository.findAll()).thenReturn(pay);
		assertEquals(pay,service.getAllPaymentDetails());
		//Mockito.verify(paymentRepository,Mockito.times(1)).getPaymentDetails(paymentId);
	}
}
