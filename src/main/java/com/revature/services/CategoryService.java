package com.revature.services;

import java.util.List;

import com.revature.dao.CategoryDAO;
import com.revature.models.Category;

public class CategoryService {
	
	private CategoryDAO catDao = new CategoryDAO();
	
	
	// get all categories
	public List<Category> getAllCategories() {
		
		System.out.println("in getAllCategories() inside CategoryService");
		return catDao.getAll();
		
	}
	
	
	// get category by id
	public List<Category> getCategoryById(int catId) {
		
		System.out.println("in getCategoryById() inside CategoryService");
		if (catDao.getById(catId) != null)
			return catDao.getById(catId);
		
		return null;
		
	}
	
	

}
