package com.revature.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.dao.QuizDAO;
import com.revature.models.Quiz;

@Service
public class QuizService {
	
	private QuizDAO quizDao = new QuizDAO();
	
	public List<Quiz> getAllQuizzes() {
		return quizDao.getAll();
	}
	
	public Quiz addQuiz(Quiz newQuiz) {
//		Quiz oldQuiz = new Quiz();
		
		return quizDao.add(newQuiz);
	}
	
	public List<Quiz> getQuizById(int id) {
		return quizDao.getById(id);
	}
	
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
