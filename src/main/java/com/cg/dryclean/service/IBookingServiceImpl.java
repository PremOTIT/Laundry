package com.cg.dryclean.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dryclean.dao.IBookingRepository;
import com.cg.dryclean.dao.ICustomerRepository;
import com.cg.dryclean.dao.IOrderRepository;
import com.cg.dryclean.entity.Booking;
import com.cg.dryclean.exception.RecordNotFoundException;
import com.cg.dryclean.utility.GlobalResources;

@Service("IBookingService")
public class IBookingServiceImpl implements IBookingService {

	@Autowired
	IBookingRepository iBookingRepository;
	private Logger logger = GlobalResources.getLogger(IBookingService.class);

	@Autowired
	ICustomerRepository iCustomerRepository;

	@Autowired
	IOrderRepository iOrderRepository;

	@Override
	public Booking addBooking(Booking booking) throws RecordNotFoundException {
		String methodName = "addBooking()";
		logger.info(methodName + "Called");
		iBookingRepository.saveAndFlush(booking);
		return booking;
	}

	@Override
	public Booking removeBooking(int bookingId) throws RecordNotFoundException {
		String methodName = "removeBooking()";
		logger.info(methodName + "Called");
		Booking bean = null;
		try {
			bean = iBookingRepository.findById(bookingId).get();
		} catch (Exception e) {
			throw new RecordNotFoundException("Booking details not found!");
		}
		iBookingRepository.deleteById(bookingId);
		return bean;

	}

	@Override
	public Booking updateBooking(Booking booking) throws RecordNotFoundException {
		String methodName = "updateBooking()";
		logger.info(methodName + "Called");
		Booking bean = null;
		try {
			bean = iBookingRepository.findById(booking.getBookingId()).get();
		} catch (Exception e) {
			throw new RecordNotFoundException("Booking details not found!");
		}
		iBookingRepository.saveAndFlush(booking);
		return bean;
	}

	@Override
	public Booking getBooking(int bookingId) throws RecordNotFoundException {
		String methodName = "getBooking()";
		logger.info(methodName + "Called");
		Booking bean = null;
		try {
			bean = iBookingRepository.findById(bookingId).get();
		} catch (Exception e) {
			throw new RecordNotFoundException("Booking details not found!");
		}
		return bean;

	}

	@Override
	public List<Booking> getAllBookings() throws RecordNotFoundException {
		String methodName = "getAllBookings()";
		logger.info(methodName + "Called");
		return iBookingRepository.findAll();
	}

	@Override
	public List<Booking> getBookingsByDate(LocalDate bookingDate) throws RecordNotFoundException {
		String methodName = "getBookingsByDate()";
		logger.info(methodName + "Called");
		List<Booking> bookings = new ArrayList<Booking>();
		try {
			for (Booking i : iBookingRepository.findAll()) {
				if (i.getBookingDate() == bookingDate) {
					bookings.add(i);
				}
			}
		} catch (Exception e) {
			throw new RecordNotFoundException("Bookings details not Found");
		}
		return bookings;

	}

	@Override
	public List<Booking> getBookingsByCustomer(int customerId) throws RecordNotFoundException {
		String methodName = "getBookingsByCustomer()";
		logger.info(methodName + "Called");
		List<Booking> bookings = new ArrayList<Booking>();
		try {
			bookings = iCustomerRepository.findById(customerId).get().getBookings();
		} catch (Exception e) {
			throw new RecordNotFoundException("Bookings details not Found");
		}
		return bookings;
	}

}
