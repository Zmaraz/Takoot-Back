package com.revature.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.revature.models.Category;
import com.revature.models.HighScore;
import com.revature.models.Quiz;
import com.revature.models.User;

public class QuizDAO implements DAO<Quiz>{

	public List<Quiz> getAll() {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(User.class)
				.addAnnotatedClass(Quiz.class)
				.addAnnotatedClass(HighScore.class)
				.addAnnotatedClass(Category.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Query quizQuery = session.getNamedQuery("getAllQuizzes");
			
			List<Quiz> quizzes = quizQuery.getResultList();
			
			for(Quiz q: quizzes) {
				System.out.println(q);
			}
			
			return quizzes;
		} catch (Exception e) {
			// If an exception occurs, rollback the transaction
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		} finally {
			factory.close();
		}
	}

	public List<Quiz> getById(int id) {
		return null;
	}

	public Quiz add(Quiz obj) {
		return null;
	}

	public Quiz update(Quiz updatedObj) {
		return null;
	}

	public boolean delete(int id) {
		
		return false;
	}
	
	
	
	

}
