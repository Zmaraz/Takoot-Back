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

public class CategoryDAO implements DAO<Category>{
	
	public List<Category> getAll(){
		
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
			
			Query categoryQuery = session.getNamedQuery("getAllCateogories");
			
			List<Category> categories = categoryQuery.getResultList();
			
			for(Category c: categories) {
				System.out.println(c);
			}
			
			return categories;
		} catch (Exception e) {
			// If an exception occurs, rollback the transaction
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		} finally {
			factory.close();
		}
	}
	
	public List<Category> getById(int id){
		
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
			
			Query categoryQuery = session.getNamedQuery("getCategoryById");
			
			categoryQuery.setParameter("category_id", id);
			
			List<Category> category = categoryQuery.getResultList();
			
			for(Category c: category) {
				System.out.println(c);
			}
			
			return category;
			
		} catch (Exception e) {
			// If an exception occurs, rollback the transaction
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		} finally {
			factory.close();
		}
	}
	
	public Category add(Category newCategory, Principal principal) {
		return null;
	}
	
	public Category update(Category updatedCategory) {
		return null;
	}
	
	public boolean delete(int id) {
		return false;
	}

}
