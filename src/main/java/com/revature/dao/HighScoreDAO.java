package com.revature.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.revature.models.HighScore;
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
				.addAnnotatedClass(HighScore.class)
				.addAnnotatedClass(User.class)
				.addAnnotatedClass(Quiz.class)
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
		return null;
	}
	
	public HighScore add(HighScore newHighScore) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(HighScore.class)
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
