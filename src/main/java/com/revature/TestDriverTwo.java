package com.revature;

import com.revature.models.Principal;
import com.revature.models.Quiz;
import com.revature.services.QuizService;

public class TestDriverTwo {

	public static void main(String[] args) {
		
		QuizService qS = new QuizService();
		Quiz myQuiz = new Quiz(2, "Quiz Title", "5/4/2019", "5/5/2019", 1, 2);
		Principal principal = new Principal(1, "Shake", "password");
		qS.addQuiz(myQuiz, principal);
		
	}
	
}
