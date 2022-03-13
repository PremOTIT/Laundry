package com.cg.dryclean.controller;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dryclean.entity.Booking;
import com.cg.dryclean.exception.RecordNotFoundException;
import com.cg.dryclean.service.IBookingService;
import com.cg.dryclean.utility.GlobalResources;

@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	IBookingService iBookingService;
	private Logger logger = GlobalResources.getLogger(IBookingService.class);

	@PostMapping("/bookings")
	public Booking addBooking(@RequestBody Booking bookings) throws RecordNotFoundException {
		String methodName = "addBooking()";
		logger.info(methodName + "Called");
		return iBookingService.addBooking(bookings);
	}

	@DeleteMapping("/booking/{Id}")
	public Booking removeBooking(@PathVariable int Id) throws RecordNotFoundException {
		String methodName = "removeBooking()";
		logger.info(methodName + "Called");
		return iBookingService.removeBooking(Id);
	}

	@PutMapping("/bookings")
	public Booking updateBooking(@RequestBody Booking bookings) throws RecordNotFoundException {
		String methodName = "updateBooking()";
		logger.info(methodName + "Called");
		return iBookingService.updateBooking(bookings);
	}

	@GetMapping("/bookings/{Id}")
	public Booking getBooking(@PathVariable int Id) throws RecordNotFoundException {
		String methodName = "getBooking()";
		logger.info(methodName + "Called");
		return iBookingService.getBooking(Id);
	}

	@GetMapping("/bookings")
	public List<Booking> getAllBookings() throws RecordNotFoundException {
		String methodName = "getAllBookings()";
		logger.info(methodName + "Called");
		return iBookingService.getAllBookings();

	}

	@GetMapping("/getbookingsbydate/{bookingDate}")
	public List<Booking> getBookingsByDate(
			@RequestParam("localDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate bookingDate)
			throws RecordNotFoundException {
		String methodName = "getBookingsByDate()";
		logger.info(methodName + "Called");
		return iBookingService.getBookingsByDate(bookingDate);
	}

	@GetMapping("/getbookingsbycustomer/{Id}")
	public List<Booking> getBookingsByCustomer(@PathVariable int Id) throws RecordNotFoundException {
		String methodName = "getBookingsByCustomer()";
		logger.info(methodName + "Called");
		return iBookingService.getBookingsByCustomer(Id);
	}

}
