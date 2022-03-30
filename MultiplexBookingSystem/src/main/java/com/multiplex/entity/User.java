package com.multiplex.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**************************
 * User Entity Class
 * 
 * Created By: Nimesh Lande
 * Date: 17/03/2022
 ***************************/

@Entity
@Table(name = "users")
public class User {

	@Id
	@Column(name = "userId")
	private int userId;

	@Column(name = "userName")
	private String userName;

	@Column(name = "userType")
	private String userType;

	@Column(name = "emailId")
	private String emailId;

	@Column(name = "password")
	private String password;

	@Column(name = "mobileNumber")
	private String mobileNumber;

	public User() {
		super();
	}

	public User(int userId, String userName, String userType, String emailId, String password, String mobileNumber) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userType = userType;
		this.emailId = emailId;
		this.password = password;
		this.mobileNumber = mobileNumber;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

}
