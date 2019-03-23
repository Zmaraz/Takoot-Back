package com.revature.services;

import java.util.List;

import com.revature.dao.HighScoreDAO;
import com.revature.models.HighScore;

public class HighScoreService {
	
	private HighScoreDAO scoreDao = new HighScoreDAO();
	
	
	// get all highscores
	public List<HighScore> getAllHighScores() {
		
		System.out.println("inside of getAllHighScores() in HighScoreService");
		return scoreDao.getAll();
		
	}
	
	
	// get all highscores for a user given a userId
	public List<HighScore> getScoresByUserId(int userId) {
		
		System.out.println("inside of getScoresByUserId() in HighScoreService");
		if (userId > 0)
			return scoreDao.getByUserId(userId);
		
		return null;
		
	}
	
	
	// get all highscores for a quiz given a quizId
	public List<HighScore> getScoresByQuizId(int quizId) {
		
		System.out.println("inside of getScoresByQuizId() in HighScoreService");
		if (quizId > 0) 
			return scoreDao.getByQuizId(quizId);
		
		return null;
		
	}

	
	
}
