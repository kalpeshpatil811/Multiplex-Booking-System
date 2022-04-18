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

import com.multiplex.entity.Hall;
import com.multiplex.exception.HallAlreadyExistException;
import com.multiplex.exception.HallNotFoundException;
import com.multiplex.service.IHallService;

/**************************
 * Hall Controller Class
 *
 * Created By: Akshata Gurupwar
 * Date:18/03/2022
 ***************************/

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/multiplex")
public class HallController {

	@Autowired
	private IHallService ihallservice;
	
	
	//PostMapping

	/* Method: addHall(@RequestBody Hall hall)
		 * Description: It allows to update the Halls
		 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type
		 * @PostMapping: It is used to handle the HTTP POST requests matched with given URL expression.
	     */
	
	@PostMapping("/halls")
	public ResponseEntity<Hall> addHall(@RequestBody Hall hall) throws HallAlreadyExistException {
		ihallservice.addHall(hall);
		return new ResponseEntity<>(hall, HttpStatus.OK);
	}
	
	//GetMapping

	/*  Method: getAllHall()
		 * Description: It allows to get all the Halls
		 * @RequestMapping: It is used to map HTTP requests to handler methods of MVC and REST controllers.
		 * @RestController: It is used to create RESTful web services using MVC.
		 * @PostMapping: It is used to handle the HTTP POST requests matched with given URL expression.
		 * @Autowired: It enables to inject object dependency implicitly.
		 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type
		 * @PathVariable: It is used to handle template variables in the request URL
	     
		 */
	
	@GetMapping("/halls")
	public List<Hall> getHall() {
		return this.ihallservice.getHall();
	}
	
	//Update(Put) Mapping

	/* Method: updateHall(@RequestBody Hall hall)
		 * Description: It allows to update the Hall
		 * @PutMapping: It is used to handle the HTTP PUT requests matched with given URL expression.
		 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type
		 * @PathVariable: It is used to handle template variables in the request URL
	     */
	
	@PutMapping("/halls")
	public ResponseEntity<Hall> updateHall(@RequestBody Hall hall) {
		ihallservice.updateHall(hall);
		return new ResponseEntity<>(hall, HttpStatus.OK);
	}
	
	//DeleteMapping

	/* Method: deleteHall(hallId)
		 * Description: It allows to remove the hall
		 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type
		 * @DeleteMapping: It is used to handle the HTTP DELETE requests matched with given URL expression.
	     */
	
	@DeleteMapping("/halls/{hallId}")
	public ResponseEntity<HttpStatus> deleteHall(@PathVariable Integer hallId) throws HallNotFoundException {
		try {
			this.ihallservice.deleteHall(hallId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//GetMapping By I'd

	/* Method: getHall(@PathVariable Integer hallId )
		 * Description: It allows you to get the Hall by I'd.
		 * @PathVariable: It is used to handle template variables in the request URL
		 * @GetMapping:It is used to handle the HTTP GET requests matched with given URL Expression.
	     */
	
	@GetMapping("/halls/{hallId}")
	public Hall getHallById(@PathVariable Integer hallId) throws HallNotFoundException {
		return ihallservice.getHallById(hallId);
	}
}
