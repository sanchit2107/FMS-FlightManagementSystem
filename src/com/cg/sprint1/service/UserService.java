package com.cg.sprint1.service;

import java.util.List;

import com.cg.sprint1.bean.User;

/**
 * 
 * @author Riya Upadhyaya
 *
 */

public interface UserService {
	
	public User addUser(User u);
	public User viewUser(long userID);
	public List<User> viewUser();
	public User updateUser(User u);
	public void deleteUser(long userID);
	public User validateUser(User u);
	
}
