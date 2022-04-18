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

import com.multiplex.entity.Movies;
import com.multiplex.exception.MovieNotFoundException;
import com.multiplex.service.IMoviesService;

/**************************
 * Movies Controller Class
 *
 * Created By: Akshata Gurupwar
 * Date:18/03/2022
 ***************************/

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/multiplex")
public class MoviesController {
	@Autowired
	private IMoviesService imoviesservice;
	

	//PostMapping

	/* Method: addMovies(@RequestBody Movies Movies)
		 * Description: It allows to update the Movies
		 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type
		 * @PostMapping: It is used to handle the HTTP POST requests matched with given URL expression.
	     */

	@PostMapping("/movies")
	public ResponseEntity<Movies> addHall(@RequestBody Movies movies) {
		imoviesservice.addMovies(movies);
		return new ResponseEntity<>(movies, HttpStatus.OK);
	}
	
	//GetMapping

	/*  Method: getAllMovies()
		 * Description: It allows to get all the Movies
		 * @RequestMapping: It is used to map HTTP requests to handler methods of MVC and REST controllers.
		 * @RestController: It is used to create RESTful web services using MVC.
		 * @PostMapping: It is used to handle the HTTP POST requests matched with given URL expression.
		 * @Autowired: It enables to inject object dependency implicitly.
		 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type
		 * @PathVariable: It is used to handle template variables in the request URL
	     
		 */
	
	@GetMapping("/movies")
	public List<Movies> getMovies() {
		return imoviesservice.getMovies();
	}
	
	//Update(Put) Mapping

	/* Method: updateMovies(@RequestBody Movies Movies)
		 * Description: It allows to update the Movies
		 * @PutMapping: It is used to handle the HTTP PUT requests matched with given URL expression.
		 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type
		 * @PathVariable: It is used to handle template variables in the request URL
	     */

	@PutMapping("/movies")
	public ResponseEntity<Movies> updateMovies(@RequestBody Movies movies) {
		imoviesservice.updateMovies(movies);
		return new ResponseEntity<>(movies, HttpStatus.OK);
	}
	
	//DeleteMapping

	/* Method: deleteMovies(MovieId)
		 * Description: It allows to remove the Movies
		 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type
		 * @DeleteMapping: It is used to handle the HTTP DELETE requests matched with given URL expression.
	     */
	
	@DeleteMapping("/movies/{moviesId}")
	public ResponseEntity<HttpStatus> deleteMovies(@PathVariable Integer moviesId) throws MovieNotFoundException {
		try {
			imoviesservice.deleteMovies(moviesId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//GetMapping By I'd

	/* Method: getMovies(@PathVariable Integer MoviesId )
		 * Description: It allows you to get the Movie by I'd.
		 * @PathVariable: It is used to handle template variables in the request URL
		 * @GetMapping:It is used to handle the HTTP GET requests matched with given URL Expression.
	     */
	
	@GetMapping("/movies/{moviesId}")
	public Movies getMoviesById(@PathVariable Integer moviesId) throws MovieNotFoundException {
		return imoviesservice.getMoviesById(moviesId);
	}

}
