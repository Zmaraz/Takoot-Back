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
		if (quizId > 0)
			return quizDao.getById(quizId);
		
		return null;
		
	}
	
	
	// update a quiz given a quiz
	public Quiz updateQuiz(Quiz updatedQuiz) {
		return quizDao.update(updatedQuiz);
	}
	
	public boolean delete (int id) {
		return quizDao.delete(id);
	}
	
	// getGuestQuiz
	
	// getQuizLeaderboard
	
	// addToLeaderboard
	
	// addFlagToQuiz

}
