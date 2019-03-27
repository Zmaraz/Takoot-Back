package com.revature.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.dao.QuizDAO;
import com.revature.models.Principal;
import com.revature.models.Quiz;

@Service
public class QuizService {
	
	private QuizDAO quizDao = new QuizDAO();
	
	
	// get all quizzes
	public List<Quiz> getAllQuizzes() {
		return quizDao.getAll();
	}
	
	// add a new quiz
	public Quiz addQuiz(Quiz newQuiz, Principal principal) {

		if (newQuiz.getTitle().equals("") ||
				newQuiz.getDateCreated().equals("") ||
				newQuiz.getDateLastUpdated().equals("") ||
				newQuiz.getDifficultyId() == 0)
			return null;
		
		if (newQuiz.getDefaultId() == 1 || newQuiz.getDefaultId() == 2) {
			quizDao.add(newQuiz, principal);
		}
		
		return newQuiz;
	}
	
	// get a quiz by the given quizId
	public List<Quiz> getQuizById(int quizId) {
		
		List<Quiz> quizzes = quizDao.getById(quizId);
		
		if (quizzes != null)
			return quizzes;
		
		return null;
	}
	
	public List<Quiz> getByAuthorId(int authorId) {
		return quizDao.getByAuthorId(authorId);
	}
	
	public List<Quiz> getByCategory(int categoryId) {
		return quizDao.getByCategory(categoryId);
	}
	
	public List<Quiz> getByDifficulty(int difficultyId) {
		return quizDao.getByDifficulty(difficultyId);
	}
	
	public List<Quiz> getByDefaultStatus(int defaultId) {
		return quizDao.getByDefaultStatus(defaultId);
	}
	
	// update a quiz given a quiz
	public Quiz updateQuiz(Quiz updatedQuiz) {
		
		if (updatedQuiz.getTitle().equals("") ||
				updatedQuiz.getDateCreated().equals("") ||
				updatedQuiz.getDateLastUpdated().equals("") ||
				updatedQuiz.getDifficultyId() == 0)
			return null;
		
		if (updatedQuiz.getDefaultId() == 1 || updatedQuiz.getDefaultId() == 2) {
			quizDao.update(updatedQuiz);
		}
		
		return updatedQuiz;
	}
	
	
	// delete a quiz given its quiz id
	public boolean deleteUser (int quizId) {
		return false;
	}
}
