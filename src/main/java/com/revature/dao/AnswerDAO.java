package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.revature.models.Answer;
import com.revature.models.Question;


public class AnswerDAO implements DAO<Answer>{
	
	public List<Answer> getAll(){
		return null;
	}
	
	public List<Answer> getById(int id){
		return null;
	}
	
	public List<Answer> getByQuestionId(int questionId){
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Answer.class)
				.addAnnotatedClass(Question.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Question question = session.get(Question.class, questionId);
			System.out.println(question);
			
			List<Answer> answers = question.getAnswers();
			for(Answer answer : answers) System.out.println("\t" + answer);
			
			session.getTransaction().commit();
			
			return answers;
			
		} catch (Exception e) {
			// If an exception occurs, rollback the transaction
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		} finally {
			factory.close();
		}
	}
	
	public Answer add(Answer newAnswer) {
		return null;
	}
	
	public Answer update(Answer updatedAnswer) {
		return null;
	}
	
	public boolean delete(int id) {
		return false;
	}
}
