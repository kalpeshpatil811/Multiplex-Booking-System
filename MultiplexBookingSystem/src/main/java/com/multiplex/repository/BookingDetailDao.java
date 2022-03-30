package com.multiplex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiplex.entity.BookingDetail;

public interface BookingDetailDao extends JpaRepository<BookingDetail, Integer> {

}
