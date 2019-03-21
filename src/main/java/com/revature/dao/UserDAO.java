package com.revature.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.revature.models.User;

public class UserDAO implements DAO<User>{
	
	public List<User> getAll() {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(User.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Query userQuery = session.getNamedQuery("getAllUsers");
			
			List<User> users = userQuery.getResultList();
			
			for(User u: users) {
				System.out.println(u);
			}
			
			return users;
		} catch (Exception e) {
			// If an exception occurs, rollback the transaction
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		} finally {
			factory.close();
		}
	}

	public User getById(int id) {
		return null;
	}

	public User add(User obj) {
		return null;
	}

	public User update(User updatedObj) {
		return null;
	}

	public boolean delete(int id) {
		return false;
	}
	
	// added getByCredentials
	public User getByCredentials(String username, String password) {
		return null;
	}
	
	// added getByUsername
	public User getByUsername(String username) {
		return null;
	}

}
