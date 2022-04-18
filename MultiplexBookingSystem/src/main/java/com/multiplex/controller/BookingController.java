package com.multiplex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multiplex.entity.Booking;
import com.multiplex.exception.BookingAlreadyExistException;
import com.multiplex.exception.BookingNotFoundException;
import com.multiplex.service.IBookingService;

/**************************
 * Booking Controller Class
 *
 * Created By: Kalpesh Patil
 * Date:18/03/2022
 ***************************/

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/multiplex")
public class BookingController {
	
	@Autowired
	IBookingService bookingService;
	
	// GetMapping

	/*  Method: getAllBookings()
		 * Description: It allows to get all the Bookings.
		 * @RequestMapping: It is used to map HTTP requests to handler methods of MVC and REST controllers.
		 * @RestController: It is used to create RESTful web services using MVC.
		 * @PostMapping: It is used to handle the HTTP POST requests matched with given URL expression.
		 * @Autowired: It enables to inject object dependency implicitly.
		 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type
		 * @PathVariable: It is used to handle template variables in the request URL
		 */
	
	@GetMapping("/bookings")
	public List<Booking> getAllBookings() {
		return bookingService.getAllBookings();
	}
	
	// PostMapping

	/* Method: addBooking(@RequestBody Booking booking)
		 * Description: It allows to add the Booking.
		 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type
		 * @PostMapping: It is used to handle the HTTP POST requests matched with given URL expression.
	     */
	
	@PostMapping("/bookings")
	public Booking addBooking(@RequestBody Booking booking) throws BookingAlreadyExistException {
		return bookingService.addBooking(booking);
	}
	
	// Put Mapping

	/* Method: updateBooking(@RequestBody Booking booking)
		 * Description: It allows to update the Booking.
		 * @PutMapping: It is used to handle the HTTP PUT requests matched with given URL expression.
		 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type
		 * @PathVariable: It is used to handle template variables in the request URL
	     */
	@PutMapping("/bookings")
	public Booking updateBooking(@RequestBody Booking booking) {
		return bookingService.updateBooking(booking);
	}
	
	// GetMapping By I'd

	/* Method: getBookingById(@PathVariable Integer bookingId)
		 * Description: It allows you to get the Seat by I'd.
		 * @PathVariable: It is used to handle template variables in the request URL
		 * @GetMapping:It is used to handle the HTTP GET requests matched with given URL Expression.
	     */
	
	@GetMapping("/bookings/{bookingId}")
	public Booking getBookingById(@PathVariable Integer bookingId) throws BookingNotFoundException {
		return bookingService.getBookingById(bookingId);
	}
	
	// Delete Mapping

	/* Method: deleteBookingById(@PathVariable Integer bookingId)
		 * Description: It allows to remove the Seats.
		 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type
		 * @DeleteMapping: It is used to handle the HTTP DELETE requests matched with given URL expression.
	     */
	
	@DeleteMapping("/bookings/{bookingId}")
	public ResponseEntity<HttpStatus> deleteBookingById(@PathVariable Integer bookingId)
			throws BookingNotFoundException {
		try {
			bookingService.deleteBookingById(bookingId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
