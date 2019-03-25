package com.revature.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.dao.FlagDAO;
import com.revature.dao.QuestionDAO;
import com.revature.models.Flag;

@Service
public class FlagService {
	
	private FlagDAO flagDao = new FlagDAO();
	private QuestionDAO questDao = new QuestionDAO();
	
	// get flag by question id
	public List<Flag> getFlagByQuestionId(int questionId) {
			return flagDao.getByQuestionId(questionId);
	}
	
	// add a new flag
	public Flag addFlag(Flag newFlag) {
		
		if (newFlag.getDescription().equals("")) 
			return null;
		
		return flagDao.add(newFlag);
		
	}

}
