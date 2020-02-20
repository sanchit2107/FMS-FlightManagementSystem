package com.cg.sprint1.bean;

/**
 * 
 * @author Sanchit Singhal/Piyush/Sadia/Riya
 *
 */

public class User {

	private String userType;
	private long userId;
	private String userName;
	private String password;
	private long userPhone;
	private String userEmail;

	public User(long userId, String userType, String userName, String password, 
			long userPhone, String userEmail) {
		super();
		this.userType = userType;
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.userPhone = userPhone;
		this.userEmail = userEmail;

	}

	public User() {
		
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(long userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


}
