package com.cg.dryclean.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.dryclean.entity.Booking;
import com.cg.dryclean.exception.RecordNotFoundException;

public interface IBookingService {

	public Booking addBooking(Booking booking) throws RecordNotFoundException;

	public Booking removeBooking(int bookingId) throws RecordNotFoundException;

	public Booking updateBooking(Booking booking) throws RecordNotFoundException;

	public Booking getBooking(int bookingId) throws RecordNotFoundException;

	public List<Booking> getAllBookings() throws RecordNotFoundException;

	public List<Booking> getBookingsByDate(LocalDate bookingDate) throws RecordNotFoundException;

	public List<Booking> getBookingsByCustomer(int customerId) throws RecordNotFoundException;
}
