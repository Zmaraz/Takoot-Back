package com.revature.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.dao.HighScoreDAO;
import com.revature.dao.QuizDAO;
import com.revature.dao.UserDAO;
import com.revature.models.HighScore;

@Service
public class HighScoreService {
	
	private HighScoreDAO scoreDao = new HighScoreDAO();
	private QuizDAO quizDao = new QuizDAO();
	private UserDAO userDao = new UserDAO();
	
	
	// get all highscores
	public List<HighScore> getAllHighScores() {
		return scoreDao.getAll();
	}
	
	// get all highscores for a user given a userId
	public List<HighScore> getScoresByUserId(int userId) {
		return scoreDao.getByUserId(userId);
	}
	
	
	// get all highscores for a quiz given a quizId
	public List<HighScore> getScoresByQuizId(int quizId) {
		return scoreDao.getByQuizId(quizId);
	}
	
	// add a new highscore
	public HighScore addHighScore(HighScore newScore) {
		
		if (newScore.getScore() < 0)
			return null;
			
		return scoreDao.add(newScore);
		
	}
	
	// updating a new highscore
	public HighScore updateHighScore(HighScore updatedHighScore) {
		
		if (updatedHighScore != null && updatedHighScore.getScore() >=0 )
			return scoreDao.update(updatedHighScore);
		
		return null;
		
	}
	
	
	// delete a highscore
	public boolean deleteHighScore(int scoreId) {
		
		if (scoreDao.getById(scoreId) != null) 
			return scoreDao.delete(scoreId);
		
		return false;
		
	}
	
}
