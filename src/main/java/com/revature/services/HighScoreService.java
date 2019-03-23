package com.revature.services;

import java.util.List;

import com.revature.dao.HighScoreDAO;
import com.revature.dao.QuizDAO;
import com.revature.dao.UserDAO;
import com.revature.models.HighScore;

public class HighScoreService {
	
	private HighScoreDAO scoreDao = new HighScoreDAO();
	private QuizDAO quizDao = new QuizDAO();
	private UserDAO userDao = new UserDAO();
	
	
	// get all highscores
	public List<HighScore> getAllHighScores() {
		
		System.out.println("inside of getAllHighScores() in HighScoreService");
		return scoreDao.getAll();
		
	}
	
	
	// get all highscores for a user given a userId
	public List<HighScore> getScoresByUserId(int userId) {
		
		System.out.println("inside of getScoresByUserId() in HighScoreService");
		if (userDao.getById(userId) != null)
			return scoreDao.getByUserId(userId);
		
		return null;
		
	}
	
	
	// get all highscores for a quiz given a quizId
	public List<HighScore> getScoresByQuizId(int quizId) {
		
		System.out.println("inside of getScoresByQuizId() in HighScoreService");
		if (quizDao.getById(quizId) != null) 
			return scoreDao.getByQuizId(quizId);
		
		return null;
		
	}
	
	
	// add a new highscore
	public HighScore addHighScore(HighScore newScore) {
		
		System.out.println("in addHighScore inside of the HighScoreService");
		if (newScore != null)
			return scoreDao.add(newScore);
		
		return null;
		
	}

	
	// updating a new highscore
	public HighScore updateHighScore(HighScore updateHighScore) {
		
		System.out.println("in updateHighScore() in ");
		if (updateHighScore != null)
			return scoreDao.update(updateHighScore);
		
		return null;
		
	}
	
	
	// delete a highscore
	public boolean deleteHighScore(int scoreId) {
		
		System.out.println("in deleteHighScore() inside of HighScoreService");
		if (scoreDao.getById(scoreId) != null) 
			return scoreDao.delete(scoreId);
		
		return false;
		
	}
	
}
