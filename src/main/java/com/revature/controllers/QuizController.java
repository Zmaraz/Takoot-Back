package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

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

import com.fasterxml.jackson.annotation.JsonView;
import com.revature.dtos.QuizDTO;
import com.revature.exceptions.ObjectErrorResponse;
import com.revature.exceptions.ObjectNotFoundException;
import com.revature.filters.jsonview.QuizView;
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
	
	@JsonView(QuizView.Public.class)
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Quiz> getAllQuizzes(HttpServletRequest req) {
		Principal principal = (Principal) req.getAttribute("principal");
		System.out.println("Principal in quiz controller: " + principal); // able to get principal object from request
																			// header.

		List<Quiz> initialQuizzes = quizService.getAllQuizzes();
		List<Quiz> defaultQuizzes = new ArrayList<>();
				
		defaultQuizzes.forEach(System.out::println);
				
		System.out.println("initial Quizzes.");
		initialQuizzes.forEach(System.out::println);
		
		if (principal == null) {
			initialQuizzes.stream().filter(qz -> qz.getDefaultId() == 1).forEach(defaultQuizzes::add);
			System.out.println("About to print defaultQuizzes: " + "or is it empty: " + defaultQuizzes.isEmpty());
			System.out.println(initialQuizzes + "or is it empty: " + initialQuizzes.isEmpty());
			return defaultQuizzes;
			}

		return initialQuizzes;
	}

	@JsonView(QuizView.Public.class)
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Quiz getQuizById(@PathVariable int id) {

		List<Quiz> quizzes = quizService.getQuizById(id);
		Optional<Quiz> quiz = quizzes.stream().filter(qz -> qz.getQuizId() == id).findFirst();
		if (quiz.isPresent()) {
			System.out.println(quiz);
			
			return quiz.get();
		} else
			throw new ObjectNotFoundException("No quiz with id: " + id + " found");
	}

	@JsonView(QuizView.Public.class)
	@PatchMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<Quiz> updateQuiz(@RequestBody QuizDTO updatedQuiz) {
		
		Quiz updatingQuiz = new Quiz(updatedQuiz.getQuizId(), updatedQuiz.getTitle(), updatedQuiz.getDateCreated(), 
				updatedQuiz.getDateLastUpdated(), updatedQuiz.getDifficultyId(), updatedQuiz.getDefaultId());
		Quiz newQuiz = quizService.updateQuiz(updatingQuiz);
		
		
		if (newQuiz == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

			return new ResponseEntity<>(newQuiz, HttpStatus.OK);
	}

	@JsonView(QuizView.Public.class)
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public Quiz addQuiz(@RequestBody QuizDTO quiz, @RequestAttribute("principal") Principal principal) {
		
		int categoryId = quiz.getCategoryId();
		Quiz addingQuiz = new Quiz(0, quiz.getTitle(), quiz.getDateCreated(), quiz.getDateLastUpdated(), quiz.getDifficultyId(), quiz.getDefaultId());
		return quizService.addQuiz(addingQuiz, principal, categoryId);
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
