package com.revature.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.dao.AnswerDAO;
import com.revature.dao.QuestionDAO;
import com.revature.models.Answer;

@Service
public class AnswerService {
	
	private AnswerDAO ansDao = new AnswerDAO();
	private QuestionDAO questDao = new QuestionDAO();
	
	// get answer by questionId
	public List<Answer> getAnswerByQuestionId(int questionId) {
		return ansDao.getByQuestionId(questionId);
	}
	
	
	// add a new Answer
	public Answer addAnswer(Answer newAnswer) {
		
		if (newAnswer.getAnswer().equals(""))
			return null;
		
		if (newAnswer.getAnswerValue() == 0 || newAnswer.getAnswerValue() ==1 ) {
			ansDao.add(newAnswer);
		}
		return newAnswer;
	}
	
	
	// update a existing answer
	public Answer updateAnswer(Answer updatedAnswer) {
		
		if (updatedAnswer.getAnswer().equals(""))
			return null;
		
		if (updatedAnswer.getAnswerValue() == 0 || updatedAnswer.getAnswerValue() ==1 ) {
			ansDao.update(updatedAnswer);
		}
		
		return updatedAnswer;
		
	}

}
