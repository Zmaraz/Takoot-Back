package com.revature;

import com.revature.dao.AnswerDAO;
import com.revature.dao.CategoryDAO;
import com.revature.dao.FlagDAO;
import com.revature.dao.HighScoreDAO;
import com.revature.dao.QuestionDAO;
import com.revature.dao.QuizDAO;
import com.revature.dao.UserDAO;
import com.revature.models.Answer;
import com.revature.models.Flag;
import com.revature.models.HighScore;
import com.revature.models.Question;
import com.revature.models.Quiz;
import com.revature.models.User;
import com.revature.services.AnswerService;
import com.revature.services.CategoryService;
import com.revature.services.FlagService;
import com.revature.services.HighScoreService;
import com.revature.services.QuestionService;
import com.revature.services.QuizService;
import com.revature.services.UserService;

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
		
//		FlagDAO flagDao = new FlagDAO();
//		
//		flagDao.getByQuestionId(1);
		
		//----------------------------------------------------------------
		//----------------------------------------------------------------
		
//		AnswerService aS = new AnswerService();
//		aS.getAnswerByQuestionId(1);
//		Answer myAnswer = new Answer(2, "akjsdhfa", 1);
//		aS.addAnswer(myAnswer);
//		myAnswer.setAnswer("hello");
//		aS.updateAnswer(myAnswer);
		
		//----------------------------------------------------------------
		
//		CategoryService cS = new CategoryService();
//		cS.getAllCategories();
//		cS.getCategoryById(1);
		
		//----------------------------------------------------------------
		
//		FlagService fS = new FlagService();
//		fS.getFlagByQuestionId(1);
//		Flag flag = new Flag(2, "Blah");
//		fS.addFlag(flag);
		
		//----------------------------------------------------------------
		
//		HighScoreService hSS = new HighScoreService();
//		hSS.getScoresByUserId(1);
//		HighScore myhighScore = new HighScore(2, 98);
//		hSS.addHighScore(myhighScore);
		
		//----------------------------------------------------------------
		
//		QuestionService qS = new QuestionService();
//		qS.getAllQuestions();
//		qS.getAllQuestionsByQuizId(1);
//		Question question = new Question(2, "Another question");
//		qS.addQuestion(question);
//		question.setQuestion("Updated question");
//		qS.updateQuestion(question);
		
		//----------------------------------------------------------------
		
//		QuizService quizService = new QuizService();
//		quizService.getAllQuizzes();
//		quizService.getByAuthorId(1);
//		quizService.getByCategory(3);
//		quizService.getByDifficulty(1);
//		quizService.getByDefaultStatus(1);
//		Quiz myQuiz = new Quiz(2, "Quiz Title", "5/4/2019", "5/5/2019", 1, 2);
//		quizService.addQuiz(myQuiz);
//		myQuiz.setTitle("Updated Quiz Title");
//		quizService.updateQuiz(myQuiz);
		
		//----------------------------------------------------------------
		
//		UserService uS = new UserService();
//		uS.getAllUsers();
//		uS.getUserById(4);
//		uS.getUserByUsername("Shake");
//		uS.getUserByCredentials("Shake", "password");
//		User user = new User(0, "Kyle", "Peterson", "kp88888", "password", "kpeterson@gmail.com");
//		uS.addUser(user);
//		user.setFirst_name("Jimmy");
//		uS.updateUser(user);
		
	}
}

