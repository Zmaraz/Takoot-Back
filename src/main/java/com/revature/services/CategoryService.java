package com.revature.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.dao.CategoryDAO;
import com.revature.models.Category;

@Service
public class CategoryService {
	
	private CategoryDAO catDao = new CategoryDAO();
	
	
	// get all categories
	public List<Category> getAllCategories() {
		return catDao.getAll();
	}
	
	
	// get category by id
	public List<Category> getCategoryById(int catId) {
		
		List<Category> categories = catDao.getById(catId);
		
		if (categories != null)
			return categories;
		
		return null;
		
	}
	
	

}
