package com.revature.services;

import java.util.List;

import com.revature.dao.QuestionDAO;
import com.revature.dao.QuizDAO;
import com.revature.models.Question;

public class QuestionService {

	private QuestionDAO questDao = new QuestionDAO();
	private QuizDAO quizDao = new QuizDAO();
	
	
	// get all the questions
	public List<Question> getAllQuestions() {
		
		System.out.println("inside of getAllQuestions() in QuestionService");
		return questDao.getAll();
		
	}
	
	
	// get all questions by the a quizzes id
	public List<Question> getAllQuestionsByQuizId(int quizId) {
		
		System.out.println("inside of getAllQuestionsByQuizId() in QuestionService");
		if (quizDao.getById(quizId) != null) 
			return questDao.getByQuizId(quizId);
		
		return null;
		
	}
	
	
	// add a new question
	public Question addQuestion(Question newQuestion) {
		
		System.out.println("inside of addQuestion() in QuestionService");
		if (newQuestion.getQuestion().equals("") ||
				newQuestion.getQuiz().equals("") ||
				newQuestion.getAnswers().equals(""))
			return null;
		
		return questDao.add(newQuestion);
		
	}
	
	
	// update a previous exsisting question
	public Question updateQuestion(Question updateQuestion) {
		
		System.out.println("inside of updateQuestion() in QuestionService");
		if (updateQuestion.getQuestion().equals("") ||
				updateQuestion.getQuiz().equals("") ||
				updateQuestion.getAnswers().equals("")) 
			return null;
		
		return questDao.update(updateQuestion);
		
	}
	
	
	// delete a question
	public boolean deleteQuestion(int questionId) {
		
		System.out.println("inside of deleteQuestion() in QuestionService");
		if (questionId > 0)
			return questDao.delete(questionId);
		
		return false;
		
	}
	
}
