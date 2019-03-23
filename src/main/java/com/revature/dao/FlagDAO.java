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

public class FlagDAO implements DAO<Flag>{
	
	public List<Flag> getAll(){
		return null;
	}
	
	public List<Flag> getById(int id){
		return null;
	}
	
	public List<Flag> getByQuestionId(int questionId){
		
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
			
			Question question = session.get(Question.class, questionId);
			System.out.println(question);
			
			List<Flag> flags = question.getFlags();
			for(Flag flag : flags) System.out.println("\t" + flag);
			
			session.getTransaction().commit();
			
			return flags;
			
		} catch (Exception e) {
			// If an exception occurs, rollback the transaction
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		} finally {
			factory.close();
		}
	}
	
	public Flag add(Flag newFlag) {
		
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
			
			session.save(newFlag);
			
			session.getTransaction().commit();
			
			return newFlag;
			
		} catch (Exception e) {
			// If an exception occurs, rollback the transaction
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		} finally {
			factory.close();
		}
	}
	
	public Flag update(Flag updatedFlag) {
		return null;
	}
	
	public boolean delete(int id) {
		return false;
	}
}
