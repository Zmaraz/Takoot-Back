package com.revature.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.dao.QuestionDAO;
import com.revature.dao.QuizDAO;
import com.revature.models.Question;

@Service
public class QuestionService {

	private QuestionDAO questDao = new QuestionDAO();
	private QuizDAO quizDao = new QuizDAO();
	
	
	// get all the questions
	public List<Question> getAllQuestions() {
		return questDao.getAll();
	}
	
	// get all questions by the a quizzes id
	public List<Question> getAllQuestionsByQuizId(int quizId) {
		return questDao.getByQuizId(quizId);
	}
	
	// add a new question
	public Question addQuestion(Question newQuestion) {
		
		if (newQuestion.getQuestion().equals(""))
			return null;
		
		return questDao.add(newQuestion);	
	}
	
	// update a previous exsisting question
	public Question updateQuestion(Question updateQuestion) {
		
		if (updateQuestion.getQuestion().equals("")) 
			return null;
		
		return questDao.update(updateQuestion);
	}
	
	
	// delete a question
	public boolean deleteQuestion(int questionId) {
		
		if (questionId > 0)
			return questDao.delete(questionId);
		
		return false;
	}
	
}
