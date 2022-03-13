package com.cg.dryclean.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.dryclean.entity.Booking;

@Repository
public interface IBookingRepository extends JpaRepository<Booking, Integer> {

}
