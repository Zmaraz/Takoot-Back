package com.revature.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.revature.models.Question;

public class QuestionDAO implements DAO<Question>{

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Question> getAll() {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Question.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		try {
		
		Query questionQuery = session.getNamedQuery("allQuestions");
		List<Question> allQ = questionQuery.getResultList();
		
		
		return allQ;
		} catch (Exception e) {
			session.getTransaction().rollback();
			factory.close();
			return null;
		}
	}

	@SuppressWarnings("unused")
	@Override
	public List<Question> getById(int id) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Question.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		Query questionQuery = session.getNamedQuery("questionById");
		questionQuery.setParameter("question_id", id);
		
		factory.close();
		return null;
	}

	@Override
	public Question add(Question newQ) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Question.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
try {
			
			session.beginTransaction();
			
			session.save(newQ);
			
			session.getTransaction().commit();
			
			return newQ;
			
		} catch (Exception e) {
			// If an exception occurs, rollback the transaction
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		} finally {
			factory.close();
		}
		
	}

	@Override
	public Question update(Question updatedQ) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Question.class)
				.buildSessionFactory();
		
Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			int questionId = updatedQ.getQuestionId();
			
			Question question = session.get(Question.class, questionId);
			
			question.setQuestion(updatedQ.getQuestion());
			question.setQuizId(updatedQ.getQuizId());
			
			session.getTransaction().commit();
			
			return updatedQ;
			
		} catch (Exception e) {
			// If an exception occurs, rollback the transaction
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		} finally {
			factory.close();
		}
	}

	@Override
	public boolean delete(int id) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Question.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			Question selectedQ = session.get(Question.class, id);
			
			session.delete(selectedQ);
			
			session.getTransaction().commit();
			
			return true;
		}catch (Exception e) {
			// If an exception occurs, rollback the transaction
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			factory.close();
		}
		return false;
		
	}

}
