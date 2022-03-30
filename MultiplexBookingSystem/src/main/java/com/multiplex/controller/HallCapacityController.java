package com.multiplex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multiplex.entity.HallCapacity;
import com.multiplex.service.IHallCapacityService;

/**************************
 * HallCapacity Controller Class
 *
 * Created By: Onkar Kulkarni
 * Date: 18/03/2022
 ***************************/

@RestController
@RequestMapping("/multiplex")
public class HallCapacityController {
	
	@Autowired
	IHallCapacityService hallcapService;
	
	//GetMapping

	/*  Method: getHallCapacity()
		 * Description: It allows to get all the Hall capacities
		 * @RequestMapping: It is used to map HTTP requests to handler methods of MVC and REST controllers.
		 * @RestController: It is used to create RESTful web services using MVC.
		 * @PostMapping: It is used to handle the HTTP POST requests matched with given URL expression.
		 * @Autowired: It enables to inject object dependency implicitly.
		 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type
		 * @PathVariable: It is used to handle template variables in the request URL
		 */
	
	@GetMapping("/hallCapacity")
	public List<HallCapacity> getHallCapacity() {

		return hallcapService.getHallCapacity();
	}
	
	//GetMapping By I'd

	/* Method: getHallCapacityId(@PathVariable int hallCapId)
		 * Description: It allows you to get the Hall capacity by I'd.
		 * @PathVariable: It is used to handle template variables in the request URL
		 * @GetMapping:It is used to handle the HTTP GET requests matched with given URL Expression.
	     */
	
	@GetMapping("/hallCapacity/{hallCapId}")
	public HallCapacity getHallCapacityId(@PathVariable int hallCapId) {
		return hallcapService.findByHallCapacityId(hallCapId);
	}
	
	//PostMapping

	/* Method: createHallCapacity(@Validated @RequestBody HallCapacity hallCapacity)
		 * Description: It allows to update the Hall capacity
		 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type
		 * @PostMapping: It is used to handle the HTTP POST requests matched with given URL expression.
	     */
	
	@PostMapping("/hallCapacity")
	public ResponseEntity<HallCapacity> createHallCapacity(@Validated @RequestBody HallCapacity hallCapacity) {
		HallCapacity mv = hallcapService.addHallCapacity(hallCapacity);
		return new ResponseEntity<HallCapacity>(mv, HttpStatus.OK);
	}
	
	//Update(Put) Mapping

	/* Method: updateHallCapacity(@RequestBody HallCapacity updatehallcap)
		 * Description: It allows to update the Hall capacity
		 * @PutMapping: It is used to handle the HTTP PUT requests matched with given URL expression.
		 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type
		 * @PathVariable: It is used to handle template variables in the request URL
	     */

	@PutMapping("/hallCapacity")
	public HallCapacity updateHallCapacity(@RequestBody HallCapacity updatehallcap) {
		return this.hallcapService.updateHallCapacity(updatehallcap);
	}
	
	//DeleteMapping

	/* Method: deleteHallCapacityById(@PathVariable Integer happCapId)
		 * Description: It allows to remove the hall capacity detail
		 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type
		 * @DeleteMapping: It is used to handle the HTTP DELETE requests matched with given URL expression.
	     */
	
	@DeleteMapping("/hallCapacity/{hallCapId}")
	public ResponseEntity<HttpStatus> deleteHallCapacityById(@PathVariable Integer hallCapId) {
		try {
			hallcapService.deleteHallCapacityById((hallCapId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}