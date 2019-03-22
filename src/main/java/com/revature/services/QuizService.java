package com.revature.services;

import java.util.List;

import com.revature.dao.QuizDAO;
import com.revature.models.Quiz;

public class QuizService {
	
	private QuizDAO quizDao = new QuizDAO();
	
	// Get all Quizzes
	public List<Quiz> getAllQuizzes() {
		
		System.out.println("In getAllQuizzes() inside QuizService");
		return quizDao.getAll();
		
	}
	
	
	// Add a new quiz
	public Quiz addQuiz(Quiz newQuiz) {
		
		System.out.println("In addQuiz() inside QuizService");
		if (newQuiz.getCategory().equals("") || newQuiz.getTitle().equals("") ||
				newQuiz.getQuestions() != null || newQuiz.getDifficultyId() <= 3 || newQuiz.getDefaultId() <= 2)
			return quizDao.add(newQuiz);
		
		return null;
	}
	
	
	// Get quiz by id
	public List<Quiz> getQuizById(int id) {
		
		System.out.println("In getQuizById() inside QuizService");
		if (id > 0)
			return quizDao.getById(id);
		
		return null;
	}
	
	
	// update quiz
	public Quiz updateQuiz(Quiz updatedQuiz) {
		
		System.out.println("In updateQuiz() inside QuizService");
		if (updatedQuiz != null)
			return quizDao.update(updatedQuiz);
		
		return null;
	}
	
	public boolean delete (int id) {
		
		System.out.println("In delete() inside QuizService");
		if (id > 0)
			return quizDao.delete(id);
		
		return false;
	}
	
	// getGuestQuiz
	
	// getQuizLeaderboard
	
	// addToLeaderboard
	
	// addFlagToQuiz

}
