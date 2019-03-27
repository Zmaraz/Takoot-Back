package com.revature.controllers;

import com.revature.models.Principal;
import com.revature.models.Quiz;
import com.revature.services.QuizService;
import com.revature.services.UserService;

public class ControlTest {

	public static void main(String[] args) {
		UserService uService = new UserService();
//		UserController uc = new UserController(uService);
		System.out.println("Control test");
		QuizService qService = new QuizService();
		Quiz newQuiz = new Quiz(0,"newqz", "adhoe", "ahdoa",1,2);
		QuizController qu= new QuizController(qService);
		Principal pr = new Principal(1, "Shake", "password");
		
		
//		System.out.println(uc.getAllUsers());

		
	}

}
