package com.revature.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.revature.models.Answer;
import com.revature.models.Flag;
import com.revature.models.Question;
import com.revature.models.Quiz;

public class QuestionDAO implements DAO<Question>{

	
	public List<Question> getAll() {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Question.class)
				.addAnnotatedClass(Quiz.class)
				.addAnnotatedClass(Answer.class)
				.addAnnotatedClass(Flag.class)

				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();

		try {
			
			session.beginTransaction();
			
			Query questionQuery = session.getNamedQuery("getAllQuestions");
			
			List<Question> questions = questionQuery.getResultList();
			
			for(Question q: questions) {
				System.out.println(q);
			}
			
			return questions;

		} catch (Exception e) {
			// If an exception occurs, rollback the transaction
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		} finally {
			factory.close();
		}
	}
	
	public List<Question> getById(int id){
		return null;
	}
	
	public Question add(Question newQuestion) {
		return null;
	}
	
	public Question update(Question updatedQuestion) {
		return null;
	}
	
	public boolean delete(int id) {
		return false;
	}

}
