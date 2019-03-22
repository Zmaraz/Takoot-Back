package com.revature;

import com.revature.dao.HighScoreDAO;
import com.revature.dao.QuizDAO;
import com.revature.dao.UserDAO;
import com.revature.models.HighScore;
import com.revature.models.User;

public class TestDriver {

	public static void main(String[] args) {
		
//		UserDAO userDao = new UserDAO();
//		userDao.getAll();
//		userDao.getById(2);
//		userDao.getByUsername("poorjon");
//		userDao.getByCredentials("poorjon", "password");
//		
//		User user = new User(0, "Billy", "Bob", "billybob0000", "password", "bb@gmail.com");
//		userDao.add(user);
//		
//		user.setFirst_name("Poopy");
//		userDao.update(user);
		
		//--------------------------------------------------------------
		
		HighScoreDAO highScoreDao = new HighScoreDAO();
		
//		HighScore highScore = new HighScore(0, 60);
//		
//		highScoreDao.add(highScore);
		
		
//		highScoreDao.getByUserId(2);
		highScoreDao.getByQuizId(1);
		
		//-----------------------------------------------------------------
		
		QuizDAO quizDao = new QuizDAO();
		quizDao.getAll();
		
		
	}
}