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

import com.multiplex.entity.Shows;
import com.multiplex.exception.ShowAlreadyExistException;
import com.multiplex.exception.ShowNotFoundException;
import com.multiplex.service.IShowsService;

/***************************
 * Shows Controller Class
 * 
 * Created By: Laxman Adkune
 * Date: 18/03/2022
 **************************/

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/multiplex")
public class ShowsController {

	@Autowired
	IShowsService showService;
	
	// Get

	/* Method: getShows
	 * Description: It allows to fetch all data of shows.
	 * @GetMapping:It is used to handle the HTTP GET requests matched with given URL Expression.
	 */
	
	@GetMapping("/shows")
	public List<Shows> getShows() {
		return this.showService.getShows();
	}

	// Get(ById):

	/* Method: getShowById
	 * Description: It allows to fetch show by id.
	 * @PathVariable: It is used to handle template variables in the request URL
	 * @GetMapping:It is used to handle the HTTP GET requests matched with given URL Expression.
	 */
	
	@GetMapping("/shows/{showId}")
	public Shows getShowById(@PathVariable Integer showId) throws ShowNotFoundException {
		return this.showService.getShowById((showId)); // getCourse will call Service method
	}
	
	// Post:

	/* Method: addShows
	 * Description: It allows to add the shows.
	 * @RequestMapping: It is used to map HTTP requests to handler methods of MVC and REST controllers.
	 * @RestController: It is used to create RESTful web services using MVC.
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given URL expression.
	 * @Autowired: It enables to inject object dependency implicitly.
	 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type
	 */
	
	@PostMapping("/shows")
	public Shows addShows(@RequestBody Shows addShow) throws ShowAlreadyExistException {
		return this.showService.addShows(addShow);
	}
	
	// Put:

	/* Method: updateShows
	 * Description: It allows to update the shows.
	 * @PutMapping: It is used to handle the HTTP PUT requests matched with given URL expression.
	 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type
	 */
	
	@PutMapping("/shows")
	public Shows updateShows(@RequestBody Shows updateShow) {
		return this.showService.updateShows(updateShow);
	}
	
	// Delete:

	/* Method: deleteShowById
	 * Description: It allows to remove show by id.
	 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type
	 * @DeleteMapping: It is used to handle the HTTP DELETE requests matched with given URL expression.
	 */
	
	@DeleteMapping("/shows/{showId}")
	public ResponseEntity<HttpStatus> deleteShowsById(@PathVariable Integer showId) throws ShowNotFoundException {
		try {
			showService.deleteShowsById((showId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
