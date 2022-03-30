package com.multiplex.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.multiplex.entity.User;
import com.multiplex.exception.UserAlreadyExistException;
import com.multiplex.exception.UserNotFoundException;
import com.multiplex.repository.UserDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {

	@InjectMocks
	private UserService userService;

	@Mock
	private UserDao userDao;

	@InjectMocks
	private User user;

	@BeforeEach
	public void setUp() {
		user.setUserId(101);
		user.setUserName("Kalpesh");
		user.setUserType("Admin");
		user.setEmailId("kalpesh@gmail.com");
		user.setPassword("Pass@123");
		user.setMobileNumber("9876543210");
	}

	@Test
	public void addUserDetailsTest() throws UserAlreadyExistException {
		Mockito.doReturn(user).when(userDao).save(Mockito.any());
		assertEquals(user.getUserId(), userService.addUserDetails(user).getUserId());
		assertEquals(user.getUserName(), userService.addUserDetails(user).getUserName());
	}

	@Test
	public void getAllUsersTest() {
		Mockito.doReturn(Stream.of(user, user).collect(Collectors.toList())).when(userDao).findAll();
		assertEquals(Stream.of(user, user).collect(Collectors.toList()), userService.getAllUsers());
		assertEquals(2, userService.getAllUsers().size());
	}

	@Test
	public void updateUserDetailsTest() {
		Mockito.doReturn(user).when(userDao).save(Mockito.any());
		assertEquals(user.getUserId(), userService.updateUserDetails(user).getUserId());
		assertEquals(user.getUserName(), userService.updateUserDetails(user).getUserName());
		assertEquals(user.getUserType(), userService.updateUserDetails(user).getUserType());
		assertEquals(user.getEmailId(), userService.updateUserDetails(user).getEmailId());
		assertEquals(user.getPassword(), userService.updateUserDetails(user).getPassword());
		assertEquals(user.getMobileNumber(), userService.updateUserDetails(user).getMobileNumber());
	}

	@Test
	public void showUserDetailsTest() throws UserNotFoundException {
		int userId = 101;
		Mockito.when(userDao.findById(userId)).thenReturn(Optional.of(user));
		assertEquals(user.getUserId(), userService.showUserDetails(userId).getUserId());
	}

	@Test
	public void deleteUserDetailsTest() throws UserNotFoundException {
		int userId = 1001;
		userService.deleteUserDetails(userId);
		Mockito.verify(userDao, Mockito.atLeastOnce()).deleteById(Mockito.anyInt());
	}
}
