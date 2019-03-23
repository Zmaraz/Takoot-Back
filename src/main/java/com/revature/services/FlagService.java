package com.revature.services;

import java.util.List;

import com.revature.dao.FlagDAO;
import com.revature.dao.QuestionDAO;
import com.revature.models.Flag;

public class FlagService {
	
	
	private FlagDAO flagDao = new FlagDAO();
	private QuestionDAO questDao = new QuestionDAO();
	
	// get flag by question id
	public List<Flag> getFlagByQuestionId(int questionId) {
		
		System.out.println("in getFlagByQuestionId() inside FlagService");
		if (questDao.getById(questionId) != null)
			return flagDao.getByQuestionId(questionId);
		
		return null;
		
	}
	
	
	// add a new flag
	public Flag addFlag(Flag newFlag) {
		
		System.out.println("in addFlag() inside FlagService");
		if (newFlag.getDescription().equals("") ||
				newFlag.getQuestion().equals("") ||
				newFlag.getQuestion_id() != 0)
			return null;
		
		return flagDao.add(newFlag);
		
	}

}
