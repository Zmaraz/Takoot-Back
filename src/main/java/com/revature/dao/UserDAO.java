package com.revature.dao;

import java.util.List;

import com.revature.models.User;

public class UserDAO implements DAO<User>{

	public List<User> getAll() {
		return null;
	}

	public User getById(int id) {
		return null;
	}

	public User add(User obj) {
		return null;
	}

	public User update(User updatedObj) {
		return null;
	}

	public boolean delete(int id) {
		return false;
	}
	
	// added getByCredentials
	public User getByCredentials(String username, String password) {
		return null;
	}
	
	// added getByUsername
	public User getByUsername(String username) {
		return null;
	}

}
