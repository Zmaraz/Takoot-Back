package com.revature.services;

import java.util.List;

import com.revature.dao.AnswerDAO;
import com.revature.models.Answer;

public class AnswerService {
	
	private AnswerDAO answDao = new AnswerDAO();
	
	// get all answers
	public List<Answer> getAllAnswers() {
		
		System.out.println("In getAll() inside AnswerService");
		return null;
		
	}
	
	
	// get answer by question id
	public List<Answer> getByQuestionId(int questId) {
		
		System.out.println("In getByQuestionId() inside AnswerService");
		if (questId > 0)
			return answDao.getByQuestionId(questId);
		
		return null;
		
	}
	
	
	// adding a new question
	public Answer add(Answer newAnsw) {
		
		System.out.println("In add() inside AnswerService");
		if (newAnsw != null)
			return answDao.add(newAnsw);
		
		return null;
		
	}
	
	
	// update answer
	public Answer update(Answer updateAnswer) {
		
		System.out.println("In updateAnswer() inside AnswerService");
		if (updateAnswer != null)
			return answDao.update(updateAnswer);
		
		return null;
		
	}

}
