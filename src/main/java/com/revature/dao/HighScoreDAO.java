package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.revature.models.Answer;
import com.revature.models.Category;
import com.revature.models.Flag;
import com.revature.models.HighScore;
import com.revature.models.Question;
import com.revature.models.Quiz;
import com.revature.models.User;

public class HighScoreDAO implements DAO<HighScore>{
	
	public List<HighScore> getAll() {
		return null;
	}
	
	public List<HighScore> getById(int id) {
		return null;
	}
	
	public List<HighScore> getByUserId(int userId) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(User.class)
				.addAnnotatedClass(HighScore.class)
				.addAnnotatedClass(Quiz.class)
				.addAnnotatedClass(Question.class)
				.addAnnotatedClass(Answer.class)
				.addAnnotatedClass(Category.class)
				.addAnnotatedClass(Flag.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			User user = session.get(User.class, userId);
			System.out.println(user);
			
			List<HighScore> highScores = user.getHighScores();
			for(HighScore highScore : highScores) System.out.println("\t" + highScore);
			
			session.getTransaction().commit();
			
			return highScores;
			
		} catch (Exception e) {
			// If an exception occurs, rollback the transaction
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		} finally {
			factory.close();
		}
	}
	
	public List<HighScore> getByQuizId(int quizId) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(User.class)
				.addAnnotatedClass(HighScore.class)
				.addAnnotatedClass(Quiz.class)
				.addAnnotatedClass(Question.class)
				.addAnnotatedClass(Answer.class)
				.addAnnotatedClass(Category.class)
				.addAnnotatedClass(Flag.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Quiz quiz = session.get(Quiz.class, quizId);
			System.out.println(quiz);
			
			List<HighScore> highScores = quiz.getHighScores();
			for(HighScore highScore : highScores) System.out.println("\t" + highScore);
			
			session.getTransaction().commit();
			
			return highScores;
			
		} catch (Exception e) {
			// If an exception occurs, rollback the transaction
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		} finally {
			factory.close();
		}
	}
	
	public HighScore add(HighScore newHighScore) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(User.class)
				.addAnnotatedClass(HighScore.class)
				.addAnnotatedClass(Quiz.class)
				.addAnnotatedClass(Question.class)
				.addAnnotatedClass(Answer.class)
				.addAnnotatedClass(Category.class)
				.addAnnotatedClass(Flag.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			session.save(newHighScore);
			
			session.getTransaction().commit();
			
			return newHighScore;
			
		} catch (Exception e) {
			// If an exception occurs, rollback the transaction
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		} finally {
			factory.close();
		}
	}
	
	public HighScore update(HighScore updatedHighScore) {
		return null;
	}
	
	public boolean delete(int id) {
		return false;
	}
	
}
