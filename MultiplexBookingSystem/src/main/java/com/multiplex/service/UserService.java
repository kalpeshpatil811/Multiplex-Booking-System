package com.multiplex.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiplex.entity.User;
import com.multiplex.exception.UserAlreadyExistException;
import com.multiplex.exception.UserNotFoundException;
import com.multiplex.repository.UserDao;

/**************************
 * User Service Class
 * 
 * Created By: Nimesh Lande
 * Date: 19/03/2022 
 ***************************/

@Service
public class UserService implements IUserService {

	@Autowired
	private UserDao userDao;

	@Override
	public List<User> getAllUsers() {
		return userDao.findAll();
	}

	@Override
	public User addUserDetails(User user) throws UserAlreadyExistException {
		List<User> list = userDao.findAll();
		for (User u : list) {
			if (u.getUserId() == user.getUserId()) {
				throw new UserAlreadyExistException("User already exists...");
			}
		}
		return userDao.save(user);
	}

	@Override
	public User updateUserDetails(User user) {
		return userDao.save(user);
	}

	@Override
	public User showUserDetails(int userId) throws UserNotFoundException {
		try {
			return userDao.findById(userId).get();
		} catch (Exception e) {
			throw new UserNotFoundException("User not found...");
		}
	}

	@Override
	public void deleteUserDetails(int userId) throws UserNotFoundException {
		try {
			userDao.deleteById(userId);
		} catch (Exception e) {
			throw new UserNotFoundException("User not found...");
		}
	}

}
