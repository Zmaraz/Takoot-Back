package com.revature.dao;

import java.util.List;

import com.revature.models.Principal;

public interface DAO<T> {
	
	List<T> getAll();
	List<T> getById(int id);
	T add(T obj, Principal principal);
	T update(T updatedObj);
	boolean delete(int id);

}
