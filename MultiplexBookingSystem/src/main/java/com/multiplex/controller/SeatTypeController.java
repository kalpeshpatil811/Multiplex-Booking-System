package com.multiplex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multiplex.entity.SeatType;
import com.multiplex.exception.SeatTypeNotFoundException;
import com.multiplex.service.ISeatTypeService;

/**************************
 * SeatType Controller Class
 *
 * Created By: Onkar Kulkarni 
 * Date:18/03/2022
 ***************************/

@RestController
@RequestMapping("/multiplex")
public class SeatTypeController {

	@Autowired
	ISeatTypeService seattypeservice;

	// GetMapping

	/*  Method: getAllSeatTypes()
		 * Description: It allows to get all the Seats.
		 * @RequestMapping: It is used to map HTTP requests to handler methods of MVC and REST controllers.
		 * @RestController: It is used to create RESTful web services using MVC.
		 * @PostMapping: It is used to handle the HTTP POST requests matched with given URL expression.
		 * @Autowired: It enables to inject object dependency implicitly.
		 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type
		 * @PathVariable: It is used to handle template variables in the request URL
		 */
	
	@GetMapping("/seatTypes")
	public List<SeatType> getAllSeatTypes() {
		return seattypeservice.getAllSeatTypes();
	}

	//PostMapping

	/* Method: addSeatType(@RequestBody SeatType seatType)
		 * Description: It allows to update the Seats.
		 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type
		 * @PostMapping: It is used to handle the HTTP POST requests matched with given URL expression.
	     */
	
	@PostMapping("/seatTypes")
	public SeatType addSeatType(@RequestBody SeatType seatType) {
		return seattypeservice.addSeatType(seatType);

	}

	//GetMapping By I'd

	/* Method: getSeatType(@PathVariable Integer seatTypeId )
		 * Description: It allows you to get the Seat by I'd.
		 * @PathVariable: It is used to handle template variables in the request URL
		 * @GetMapping:It is used to handle the HTTP GET requests matched with given URL Expression.
	     */
	
	@GetMapping("/seatTypes/{seatTypeId}")
	public SeatType getSeatType(@PathVariable Integer seatTypeId) throws SeatTypeNotFoundException {
		return seattypeservice.getSeatType(seatTypeId);
	}
	
	//Update(Put) Mapping

	/* Method: updateSeatType(@RequestBody SeatType seatType)
		 * Description: It allows to update the Seat.
		 * @PutMapping: It is used to handle the HTTP PUT requests matched with given URL expression.
		 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type
		 * @PathVariable: It is used to handle template variables in the request URL
	     */
	
	@PutMapping("/seatTypes")
	public SeatType updateSeatType(@RequestBody SeatType seatType) {
		return seattypeservice.updateSeatType(seatType);
	}

	//DeleteMapping

	/* Method: deleteSeatType(seatTypeId)
		 * Description: It allows to remove the Seats.
		 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type
		 * @DeleteMapping: It is used to handle the HTTP DELETE requests matched with given URL expression.
	     */
	
	@DeleteMapping("/seatTypes/{seatTypeId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable Integer seatTypeId) throws SeatTypeNotFoundException {
		try {
			this.seattypeservice.deleteSeatType(seatTypeId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
