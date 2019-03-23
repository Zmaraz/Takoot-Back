package com.revature.services;

import java.util.List;

import com.revature.dao.AnswerDAO;
import com.revature.dao.QuestionDAO;
import com.revature.models.Answer;

public class AnswerService {
	
	private AnswerDAO ansDao = new AnswerDAO();
	private QuestionDAO questDao = new QuestionDAO();
	
	// get answer by questionId
	public List<Answer> getAnswerByQuestionId(int questionId) {
		
		System.out.println("in getAnswerByQuestionId() in AnswerService");
		if (questDao.getById(questionId) != null)
			return ansDao.getByQuestionId(questionId);
		
		return null;
		
	}
	
	
	// add a new Answer
	public Answer addAnswer(Answer newAnswer) {
		
		System.out.println("in addAnswer() inside AnswerService");
		if (newAnswer.getAnswer().equals("") ||
				newAnswer.getAnswerValue() != 0 ||
				newAnswer.getQuestion().equals("")) 
			return null;
		
		return ansDao.add(newAnswer);
		
	}
	
	
	// update a existing answer
	public Answer updateAnswer(Answer updateAnswer) {
		
		System.out.println("in updateAnswer() inside AnswerService");
		if (updateAnswer.getAnswer().equals("") ||
				updateAnswer.getAnswerValue() != 0 ||
				updateAnswer.getQuestion().equals(""))
			return null;
		
		return ansDao.update(updateAnswer);
		
	}

}
