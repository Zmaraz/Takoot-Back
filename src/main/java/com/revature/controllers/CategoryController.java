package com.revature.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.exceptions.ObjectErrorResponse;
import com.revature.exceptions.ObjectNotFoundException;
import com.revature.models.Category;
import com.revature.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	private CategoryService catService;
	@Autowired
	public CategoryController(CategoryService cServer) {
		catService = cServer;
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Category> getAllCategories() {

		List<Category> categories = catService.getAllCategories();

		for (Category c : categories) {

			c.setQuizzes(null);
		}

		return categories;
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Category getCategoryById(@PathVariable int id) {

		List<Category> categories = catService.getCategoryById(id);
		
		Optional<Category> category = categories.stream().filter(cat -> cat.getCategoryId() == id).findFirst();
		
		if (category.isPresent()) {
			System.out.println(category);
			
			Category respCat = category.get();
			
			respCat.setQuizzes(null);
			
			return respCat;
		} else
			throw new ObjectNotFoundException("No category with id: " + id + " found");
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ObjectErrorResponse handleException(ObjectNotFoundException e) {
		ObjectErrorResponse error = new ObjectErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		return error;
	}
}
