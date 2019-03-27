package com.revature.dao;

import java.util.List;

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
	
	public Answer add(Answer newAnswer, Principal principal) {
		
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
			Question question = null;
			
			List<Quiz> quizzes = quizDao.getByAuthorId(principal.getId());
			for(Quiz q: quizzes) {
				List<Question> questions = q.getQuestions(); 
				for(Question quest: questions) {
					if(quest.getAnswers().size() != 4) {
						question = quest;
					}
				}
			}
			
			newAnswer.setQuestion(question);
			
			session.save(newAnswer);
			
			session.getTransaction().commit();
			
			return newAnswer;
			
		} catch (Exception e) {
			// If an exception occurs, rollback the transaction
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		} finally {
			factory.close();
		}
	}
	
	public Answer update(Answer updatedAnswer) {
		
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
			
			int answerId = updatedAnswer.getAnswerId();
			
			Answer myAnswer = session.get(Answer.class, answerId);
			
			myAnswer.setAnswer(updatedAnswer.getAnswer());
			
			session.getTransaction().commit();
			
			return updatedAnswer;
			
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
