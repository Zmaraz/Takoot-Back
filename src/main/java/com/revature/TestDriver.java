package com.revature;

import com.revature.dao.AnswerDAO;
import com.revature.dao.CategoryDAO;
import com.revature.dao.FlagDAO;
import com.revature.dao.HighScoreDAO;
import com.revature.dao.QuestionDAO;
import com.revature.dao.QuizDAO;
import com.revature.dao.UserDAO;
import com.revature.models.HighScore;
import com.revature.models.Quiz;
import com.revature.models.User;

public class TestDriver {

	public static void main(String[] args) {
		
		UserDAO userDao = new UserDAO();
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
		
//		HighScoreDAO highScoreDao = new HighScoreDAO();
		
//		HighScore highScore = new HighScore(0, 2, 1, 60);
		
//		highScoreDao.getByUserId(2);
//		highScoreDao.getByQuizId(1);
		
		//-----------------------------------------------------------------
//		
//		QuizDAO quizDao = new QuizDAO();
//		quizDao.getAll();
//		quizDao.getByDifficulty(1);
//		quizDao.getByDefaultStatus(1);
		
//		Quiz quiz = new Quiz(0, "Rah", "akhsdg", "iasdgh", 1, 1);
//		quizDao.add(quiz);
		
//		quizDao.getByAuthorId(1);
		
//		quizDao.getByCategory(1);
		
		//-------------------------------------------------------------------
		
//		QuestionDAO questionDao = new QuestionDAO();
//		questionDao.getAll();
//		questionDao.getByQuizId(1);
		
		//----------------------------------------------------------------------
		
//		CategoryDAO categoryDao = new CategoryDAO();
//		categoryDao.getAll();
//		categoryDao.getById(1);
		
		//--------------------------------------------------------------------
		
//		AnswerDAO answerDao = new AnswerDAO();
//		
//		answerDao.getByQuestionId(1);
		
		//--------------------------------------------------------------------
		
		FlagDAO flagDao = new FlagDAO();
		
		flagDao.getByQuestionId(1);
	}
}

