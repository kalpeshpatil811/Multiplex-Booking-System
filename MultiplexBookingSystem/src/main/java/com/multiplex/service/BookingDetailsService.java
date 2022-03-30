package com.multiplex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiplex.entity.BookingDetail;
import com.multiplex.exception.BookingDetailNotFoundException;
import com.multiplex.repository.BookingDetailDao;

/**************************
 * BookingDetail Service Class
 *
 * Created By: Yash Garad
 * Date: 19/03/2022 
 ***************************/

@Service
public class BookingDetailsService implements IBookingDetailsService {
	@Autowired
	BookingDetailDao bookingDetailsDao;

	@Override
	public List<BookingDetail> getAllBookingDetails() {
		return bookingDetailsDao.findAll();
	}

	@Override
	public BookingDetail getBookingDetail(Integer noOfSeats) throws BookingDetailNotFoundException {
		try {
			return bookingDetailsDao.findById(noOfSeats).get();
		} catch (Exception e) {
			throw new BookingDetailNotFoundException("Booking Detail not found...");
		}
	}

	@Override
	public BookingDetail addBookingDetail(BookingDetail bookingDetail) {
		return bookingDetailsDao.save(bookingDetail);
	}

	@Override
	public BookingDetail updateBookingDetail(BookingDetail bookingDetail) {
		bookingDetailsDao.save(bookingDetail);
		return bookingDetail;
	}

	@Override
	public void deleteBookingDetail(Integer noOfSeats) throws BookingDetailNotFoundException {
		try {
			bookingDetailsDao.deleteById(noOfSeats);
		} catch (Exception e) {
			throw new BookingDetailNotFoundException("Booking Detail not found...");
		}
	}

}
