package com.revature.services;

import java.util.List;

import com.revature.dao.QuizDAO;
import com.revature.models.Quiz;

public class QuizService {
	
	private QuizDAO quizDao = new QuizDAO();
	
	
	// get all quizzes
	public List<Quiz> getAllQuizzes() {
		
		System.out.println("inside of getAllQuizzes() in QuizService");
		return quizDao.getAll();
		
	}
	
	
	// add a new quiz
	public Quiz addQuiz(Quiz newQuiz) {

		System.out.println("inside of addQuiz() in QuizService");
		if (newQuiz != null)
			return quizDao.add(newQuiz);
		
		return null;
		
	}
	
	
	// get a quiz by the given quizId
	public List<Quiz> getQuizById(int quizId) {
		
		System.out.println("inside of getQuizById() in QuizService");
		if (quizDao.getById(quizId) != null)
			return quizDao.getById(quizId);
		
		return null;
		
	}
	
	
	// update a quiz given a quiz
	public Quiz updateQuiz(Quiz updatedQuiz) {
		
		System.out.println("inside of updateQuiz() in QuizService");
		if (updatedQuiz != null)
			return quizDao.update(updatedQuiz);
	
		return null;
		
	}
	
	
	// delete a quiz given its quiz id
	public boolean deleteUser (int quizId) {
		
		System.out.println("inside of deleteUser() in UserService");
		if (quizDao.getById(quizId) != null)
			return quizDao.delete(quizId);
	
		return false;
		
	}
	
	// getGuestQuiz
	
	// getQuizLeaderboard
	
	// addToLeaderboard
	
	// addFlagToQuiz

}
