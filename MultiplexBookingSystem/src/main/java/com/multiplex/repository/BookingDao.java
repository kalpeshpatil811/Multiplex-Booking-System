package com.multiplex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiplex.entity.Booking;

public interface BookingDao extends JpaRepository<Booking, Integer> {

}
