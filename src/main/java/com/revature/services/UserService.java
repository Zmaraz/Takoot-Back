package com.revature.services;

import java.util.List;

import com.revature.dao.UserDAO;
import com.revature.models.User;

public class UserService {
	
	private UserDAO userDao = new UserDAO();
	
	public List<User> getAllUsers() {
		return userDao.getAll();
	}
	
	public List<User> getUserById (int id) {
		
		if(id > 0)
			return userDao.getById(id);
		
		return null;
	}
	
	public User addUser(User newUser) {
		User oldUser = new User();
		
		String oldUsername = oldUser.getUsername();

		if (newUser.getUsername().equals("") || 
				newUser.getPassword().equals("") || 
				newUser.getFirst_name().equals("") || 
				newUser.getLast_name().equals("") ||
				newUser.getEmail().equals("")) {
			return null;
		}
		
		if(newUser.getUsername().equals(userDao.getByUsername(oldUsername))) {
			return null;
		}
		
		return userDao.add(newUser);
	}
		
	public User updateUser(User updatedUser) {
		return userDao.update(updatedUser);
	}
	
	public boolean deleteUser (int id) {
		return userDao.delete(id);
	}
	
	public List<User> getUserByCredentials(String username, String password) {
		if (!username.equals("") && !password.equals("")) {
			return userDao.getByCredentials(username, password);
		}
		return null;
	}
	
	public List<User> getUserByUsername(String username) {
		if (!username.equals("")) {
			return userDao.getByUsername(username);
		}
		return null;
	}
}
