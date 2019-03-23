package com.revature.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.exceptions.UserErrorResponse;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Principal;
import com.revature.models.Quiz;
import com.revature.services.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	private QuizService quizService;
	
	@Autowired
	public QuizController(QuizService qzService) {
		quizService = qzService;
	}
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Quiz> getAllUsers(@RequestAttribute("principal") Principal principal){
		System.out.println("Principal in user controller: " + principal); //able to get principal object from request header.
		
		return quizService.getAllQuizzes();
	}
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Quiz getUserById(@PathVariable int id, @RequestAttribute("principal") Principal principal) {
		
		List<Quiz> quizzes = quizService.getQuizById(id);
		Optional<Quiz> quiz = quizzes.stream().filter(qz -> qz.getQuizId() == id).findFirst();
		if(quiz.isPresent()){
			System.out.println(quiz);
			return quiz.get();
			}
		else 
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public UserErrorResponse handleException(UserNotFoundException e) {
		UserErrorResponse error = new UserErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		return error;
	}
	
}
