package com.cg.sprint1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.sprint1.bean.User;
import com.cg.sprint1.dao.UserDao;
import com.cg.sprint1.dao.UserDaoImpl;
import com.cg.sprint1.exceptions.InvalidPhoneNumberException;
import com.cg.sprint1.exceptions.UserNotFoundException;

/**
 * 
 * @author Riya Upadhyaya
 *
 */
public class UserServiceImpl implements UserService {

	UserDao ud = new UserDaoImpl();
	
	public boolean isValid(String s) {
		
		Pattern p  = Pattern.compile("[7-9][0-9]{9}");
		Matcher m = p.matcher(s);
		return (m.find() && m.group().equals(s));
		
	}

	@Override
	 public User addUser(User user) {
		
		long phno = user.getUserPhone();
		String pno = Long.toString(phno);
		
		if(isValid(pno)) {
			user.setUserPhone(phno);
			return ud.addUser(user);
		}
		else
			throw new InvalidPhoneNumberException("Invalid Phone Number!!");
		
	}

	@Override
	public User viewUser(long userId) {
		// TODO Auto-generated method stub
		User user = new User();
		user = ud.viewUser(userId);
		if (user != null) {
			return user;
		} else {
			throw new UserNotFoundException("!!Invalid User!!");
		}

	}

	
	@Override
	public List<User> viewUser() {
		// TODO Auto-generated method stub
		List<User> userList = new ArrayList<>();
		userList = ud.viewUser();
		if (userList != null) {
			return userList;
		} else {
			throw new UserNotFoundException("!!No User Exists!!");
		}
	}

	
	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		addUser(user);
		User us = new User();
		us = ud.updateUser(user);
		return us;

	}
	
	
	@Override
	public void deleteUser(long userID) {
		
		User u = new User();
		u = ud.viewUser(userID);
		if(u!=null) {
			ud.deleteUser(userID);
		}
		else {
			throw new UserNotFoundException("User not found for the given Id :" + userID);
		}
		
	}

	public User validateUser(User u)  {
		if (u.getUserId() < 1000 || u.getPassword().length() < 3)
			return null;
		else
			return ud.validateUser(u);
	}

}
