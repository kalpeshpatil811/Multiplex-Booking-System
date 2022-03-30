package com.multiplex.service;

import java.util.List;

import com.multiplex.entity.User;
import com.multiplex.exception.UserAlreadyExistException;
import com.multiplex.exception.UserNotFoundException;

/**************************
 * User Service Interface
 * 
 * Created By: Nimesh Lande
 * Date: 19/03/2022 
 ***************************/

public interface IUserService {

	public User addUserDetails(User user) throws UserAlreadyExistException;

	public User updateUserDetails(User user);

	public User showUserDetails(int userId) throws UserNotFoundException;

	public List<User> getAllUsers();

	public void deleteUserDetails(int userId) throws UserNotFoundException;

}
