package com.multiplex.service;

import java.util.List;

import com.multiplex.entity.BookingDetail;
import com.multiplex.exception.BookingDetailNotFoundException;

/**************************
 *BookingDetail Service Interface
 *
 * Created By: Yash Garad
 * Date: 19/03/2022 
 ***************************/

public interface IBookingDetailsService {

	List<BookingDetail> getAllBookingDetails();

	BookingDetail addBookingDetail(BookingDetail bookingDetail);

	BookingDetail getBookingDetail(Integer noOfSeats) throws BookingDetailNotFoundException;

	BookingDetail updateBookingDetail(BookingDetail bookingDetail);

	void deleteBookingDetail(Integer noOfSeats) throws BookingDetailNotFoundException;

}
