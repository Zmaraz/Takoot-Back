package com.revature.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.dao.QuizDAO;
import com.revature.models.Quiz;

@Service
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
		if (newQuiz.getDefaultId() != 0 ||
				newQuiz.getTitle().equals("") ||
				newQuiz.getCategory().equals("") ||
				newQuiz.getDefaultId() != 0 ||
				newQuiz.getDateCreated().equals("") ||
				newQuiz.getDateLastUpdated().equals("") ||
				newQuiz.getDifficultyId() != 0 ||
				newQuiz.getQuestions().equals("") ||
				newQuiz.getUser().equals(""))
			return null;
		
		return quizDao.add(newQuiz);
		
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
		if (updatedQuiz.getDefaultId() != 0 ||
				updatedQuiz.getTitle().equals("") ||
				updatedQuiz.getCategory().equals("") ||
				updatedQuiz.getDefaultId() != 0 ||
				updatedQuiz.getDateCreated().equals("") ||
				updatedQuiz.getDateLastUpdated().equals("") ||
				updatedQuiz.getDifficultyId() != 0 ||
				updatedQuiz.getQuestions().equals("") ||
				updatedQuiz.getUser().equals(""))
			return null;
	
		return quizDao.update(updatedQuiz);
		
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
