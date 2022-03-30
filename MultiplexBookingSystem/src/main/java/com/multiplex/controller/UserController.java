package com.multiplex.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multiplex.entity.User;
import com.multiplex.exception.UserAlreadyExistException;
import com.multiplex.exception.UserNotFoundException;
import com.multiplex.service.IUserService;

/**************************
 * User Controller Class
 * 
 * Created By: Nimesh Lande
 * Date: 18/03/2022 
 ***************************/

@RestController
@RequestMapping("/multiplex")
public class UserController {

	@Autowired
	private IUserService userService;
	
	// Post Mapping
	
	/* Method: addUserDeatils:
		 * Description: It allows to add new user.
		 * @RequestMapping: It is used to map HTTP requests to handler methods of MVC and REST controllers.
		 * @RestController: It is used to create RESTful web services using MVC.
		 * @PostMapping: It is used to handle the HTTP POST requests matched with given URL expression.
		 * @Autowired: It enables to inject object dependency implicitly.
		 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type
	     */
	
	@PostMapping("/users")
	public User addUserDetails(@RequestBody User user) throws UserAlreadyExistException {
		return userService.addUserDetails(user);
	}
	
	// Get Mapping
	
	/* Method: getAllUsers:
		 * Description: It allows to get all users.
		 * @GetMapping:It is used to handle the HTTP GET requests matched with given URL Expression.
	     */
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	// Get Mapping(By Id)

	/* Method: showUserDetails:
		 * Description: It allows to fetch user using userid.
		 * @PathVariable: It is used to handle template variables in the request URL
		 * @GetMapping:It is used to handle the HTTP GET requests matched with given URL Expression.
	     */
	
	@GetMapping("/users/{userId}")
	public User showUserDetails(@PathVariable("userId") int userId) throws UserNotFoundException {
		return userService.showUserDetails(userId);
	}
	
	// Put Mapping
	
	/* Method: updateUserDetails:
		 * Description: It allows to update user.
		 * @PutMapping: It is used to handle the HTTP PUT requests matched with given URL expression.
		 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type
	     */
	
	@PutMapping("/users")
	public User updateUserDetails(@RequestBody User user) {
		return userService.updateUserDetails(user);
	}
	
	// Delete Mapping(By Id)
	/* Method: deleteUserDetails:
		 * Description: It allows to remove user.
		 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type
		 * @DeleteMapping: It is used to handle the HTTP DELETE requests matched with given URL expression.
	     */
	
	@DeleteMapping("/users/{userId}")
	public void deleteUserDetails(@PathVariable("userId") int userId) throws UserNotFoundException {
		userService.deleteUserDetails(userId);
	}

}
