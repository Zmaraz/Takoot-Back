package com.revature;

import com.revature.dao.UserDAO;

public class TestDriver {
	
	public static void main(String[] args) {
		UserDAO userDao = new UserDAO();
		userDao.getAll();
	}
	
}
