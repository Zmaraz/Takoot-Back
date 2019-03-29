package com.revature.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.revature.models.Answer;
import com.revature.models.Category;
import com.revature.models.Flag;
import com.revature.models.HighScore;
import com.revature.models.Principal;
import com.revature.models.Question;
import com.revature.models.Quiz;
import com.revature.models.User;

public class QuestionDAO implements DAO<Question>{

	
	public List<Question> getAll() {
		
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
	
	public List<Question> getByQuizId(int quizId) {
		
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
			
			List<Question> questions = quiz.getQuestions();
			for(Question question : questions) System.out.println("\t" + question);
			
			session.getTransaction().commit();
			
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
	
	public Question add(Question newQuestion, Principal principal) {
		
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
			
			QuizDAO quizDao = new QuizDAO();
			Quiz quiz = null;
			
			List<Quiz> quizzes = quizDao.getByAuthorId(principal.getId());
			for(Quiz q: quizzes) {
				if(q.getQuestions().size() != 5) {
					quiz = q;
				}
			}
			
			newQuestion.setQuiz(quiz);
			
			session.save(newQuestion);
			
			session.getTransaction().commit();
			
			return newQuestion;
			
		} catch (Exception e) {
			// If an exception occurs, rollback the transaction
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		} finally {
			factory.close();
		}
	}
	
	public Question update(Question updatedQuestion) {
		
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
			
			int questionId = updatedQuestion.getQuestionId();
			
			Question myQuestion = session.get(Question.class, questionId);
			
			myQuestion.setQuestion(updatedQuestion.getQuestion());
			
			session.getTransaction().commit();
			
			return updatedQuestion;
			
		} catch (Exception e) {
			// If an exception occurs, rollback the transaction
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		} finally {
			factory.close();
		}
	}
	
	public boolean delete(int id) {
		return false;
	}

}
