package com.multiplex.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiplex.entity.Booking;
import com.multiplex.exception.BookingAlreadyExistException;
import com.multiplex.exception.BookingNotFoundException;
import com.multiplex.repository.BookingDao;

/**************************
 * Booking Service Class
 *
 * Created By: Kalpesh Patil
 * Date:19/03/2022
 ***************************/

@Service
public class BookingService implements IBookingService {

	@Autowired
	private BookingDao dao;

	@Override
	public List<Booking> getAllBookings() {
		return dao.findAll();
	}

	@Override
	public Booking addBooking(Booking booking) throws BookingAlreadyExistException {
		List<Booking> list = dao.findAll();
		for (Booking b : list) {
			if (b.getBookingId() == booking.getBookingId()) {
				throw new BookingAlreadyExistException("Booking already exists...");
			}
		}
		return dao.save(booking);
	}

	@Override
	public Booking updateBooking(Booking booking) {
		dao.save(booking);
		return booking;
	}

	@Override
	public Booking getBookingById(Integer bookingId) throws BookingNotFoundException {
		try {
			return dao.findById(bookingId).get();
		} catch (Exception e) {
			throw new BookingNotFoundException("Booking not found...");
		}
	}

	@Override
	public void deleteBookingById(Integer bookingId) throws BookingNotFoundException {
		try {
			dao.deleteById(bookingId);
		} catch (Exception e) {
			throw new BookingNotFoundException("Booking not found...");
		}
	}

}
