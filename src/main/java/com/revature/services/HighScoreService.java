package com.revature.services;

import java.util.List;

import com.revature.dao.HighScoreDAO;
import com.revature.models.HighScore;

public class HighScoreService {

	private HighScoreDAO hScoreDao = new HighScoreDAO();
	
	// Get all highscores 
	public List<HighScore> getAll() {
		
		return hScoreDao.getAll();
		
	}
	
	
	// Get highscore by Id
	public List<HighScore> getById(int hScoreId) {
		
		return hScoreDao.getById(hScoreId);
		
	}
	
	
	// Get highscore by userId 
	public List<HighScore> getByUserId(int userId) {
		
		if(userId > 0)
			return hScoreDao.getByUserId(userId);
		
		return null;
		
	}
	
	
	// Get highscores by quiz id
	public List<HighScore> getByQuizId(int quizId) {
		
		if(quizId > 0)
			return hScoreDao.getByQuizId(quizId);
		
		return null;
		
	}
	
	
	// Add a highscore to the highscore table
	public HighScore addHighScore(HighScore newHighScore) {
		
		if (newHighScore != null)
			return hScoreDao.add(newHighScore);
		
		return null;
		
	}
	
}
