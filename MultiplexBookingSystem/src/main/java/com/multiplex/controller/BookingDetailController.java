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

import com.multiplex.entity.BookingDetail;
import com.multiplex.exception.BookingDetailNotFoundException;
import com.multiplex.service.IBookingDetailsService;

/**************************
 * BookingDetail Controller Class
 *
 * Created By: Yash Garad
 * Date:18/03/2022 
 ***************************/

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/multiplex")
public class BookingDetailController {
	@Autowired
	IBookingDetailsService bookingDetailService;

	// GetMapping

	/*  Method: getAllBookingDetails()
		 * Description: It allows to get all the BookingDetail.
		 * @RequestMapping: It is used to map HTTP requests to handler methods of MVC and REST controllers.
		 * @RestController: It is used to create RESTful web services using MVC.
		 * @PostMapping: It is used to handle the HTTP POST requests matched with given URL expression.
		 * @Autowired: It enables to inject object dependency implicitly.
		 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type
		 * @PathVariable: It is used to handle template variables in the request URL
	     
		 */
	
	@GetMapping("/bookingDetails")
	public List<BookingDetail> getAllBookingDetails() {
		return bookingDetailService.getAllBookingDetails();
	}

	// PostMapping

	/* Method: addBookingDetail(@RequestBody BookingDetail bookingDetail)
		 * Description: It allows to update the BookingDetail.
		 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type
		 * @PostMapping: It is used to handle the HTTP POST requests matched with given URL expression.
	     */
	
	@PostMapping("/bookingDetails")
	public BookingDetail addBookingDetail(@RequestBody BookingDetail bookingDetail) {
		return bookingDetailService.addBookingDetail(bookingDetail);
	}

	// GetMapping By I'd

	/* Method: getBookingDetail(@PathVariable Integer noOfSeats)
		 * Description: It allows you to get the BookingDetail by I'd.
		 * @PathVariable: It is used to handle template variables in the request URL
		 * @GetMapping:It is used to handle the HTTP GET requests matched with given URL Expression.
	     */

	@GetMapping("/bookingDetail/{noOfSeats}")
	public BookingDetail getBookingDetail(@PathVariable Integer noOfSeats) throws BookingDetailNotFoundException {
		return bookingDetailService.getBookingDetail(noOfSeats);

	}

	// Update(Put) Mapping

	/* Method: updateBookingDetail(@RequestBody BookingDetail bookingDetail)
		 * Description: It allows to update the BookingDetail.
		 * @PutMapping: It is used to handle the HTTP PUT requests matched with given URL expression.
		 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type
		 * @PathVariable: It is used to handle template variables in the request URL
	     */

	@PutMapping("/bookingDetails")
	public BookingDetail updateBookingDetail(@RequestBody BookingDetail bookingDetail) {
		return bookingDetailService.updateBookingDetail(bookingDetail);
	}

	//Delete Mapping

	/* Method: deleteBookingDetail(@PathVariable Integer noOfSeats)
		 * Description: It allows to remove the BookingDetails.
		 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type
		 * @DeleteMapping: It is used to handle the HTTP DELETE requests matched with given URL expression.
	     */
	
	@DeleteMapping("/bookingDetails/{noOfSeats}")
	public ResponseEntity<HttpStatus> deleteBookingDetail(@PathVariable Integer noOfSeats) throws BookingDetailNotFoundException{
		try {
			this.bookingDetailService.deleteBookingDetail(noOfSeats);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}