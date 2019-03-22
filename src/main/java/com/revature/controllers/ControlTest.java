package com.revature.controllers;

import com.revature.models.User;
import com.revature.services.UserService;

public class ControlTest {

	public static void main(String[] args) {
		UserService uService = new UserService();
		UserController uc = new UserController(uService);
		System.out.println("Control test");
//		System.out.println(uc.deleteUser(26));
		
	}

}
