package com.revature.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.exceptions.ObjectErrorResponse;
import com.revature.exceptions.ObjectNotFoundException;
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
		else throw new ObjectNotFoundException("No quiz with id: " + id + " found");
	}
	
	@PatchMapping(consumes="application/json", produces="application/json")
	public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz updatedQuiz){
		Quiz newQuiz = quizService.updateQuiz(updatedQuiz);
		
		if(newQuiz == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else return new ResponseEntity<>(newQuiz, HttpStatus.OK);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Quiz addQuiz(@RequestBody Quiz newQuiz) {
		return quizService.addQuiz(newQuiz);
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
