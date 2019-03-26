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

import com.revature.exceptions.ObjectErrorResponse;
import com.revature.exceptions.ObjectNotFoundException;
import com.revature.models.Principal;
import com.revature.models.Quiz;
import com.revature.models.User;
import com.revature.services.QuizService;
import com.revature.services.UserService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	private QuizService quizService;

	@Autowired
	public QuizController(QuizService qzService) {
		quizService = qzService;
	}
		
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Quiz> getAllQuizzes(HttpServletRequest req) {
		Principal principal = (Principal) req.getAttribute("principal");
		System.out.println("Principal in quiz controller: " + principal); // able to get principal object from request
																			// header.

		List<Quiz> initialQuizzes = quizService.getAllQuizzes();
		List<Quiz> defaultQuizzes = new ArrayList<>();

		for (Quiz qz : initialQuizzes) {

			qz.setCategory(null);
			qz.setUser(new User(qz.getUser().getUser_id(), qz.getUser().getFirst_name(), qz.getUser().getLast_name(),
			qz.getUser().getUsername(), "***", qz.getUser().getEmail()));
			qz.setHighScores(null);
			qz.setQuestions(null);

		}
				
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

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Quiz getQuizById(@PathVariable int id) {

		List<Quiz> quizzes = quizService.getQuizById(id);
		Optional<Quiz> quiz = quizzes.stream().filter(qz -> qz.getQuizId() == id).findFirst();
		if (quiz.isPresent()) {
			System.out.println(quiz);
			
			Quiz respQuiz = quiz.get();
			User user = new User(respQuiz.getUser().getUser_id(), respQuiz.getUser().getFirst_name(), respQuiz.getUser().getLast_name(),
					respQuiz.getUser().getUsername(), "***", respQuiz.getUser().getEmail());
			
			respQuiz.setCategory(null);
			respQuiz.setUser(user);
			respQuiz.setHighScores(null);
			respQuiz.setQuestions(null);
			
			return respQuiz;
		} else
			throw new ObjectNotFoundException("No quiz with id: " + id + " found");
	}

	@PatchMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz updatedQuiz) {
		Quiz newQuiz = quizService.updateQuiz(updatedQuiz);
		
		
		if (newQuiz == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else {
			User user = new User(newQuiz.getUser().getUser_id(), newQuiz.getUser().getFirst_name(), newQuiz.getUser().getLast_name(),
			newQuiz.getUser().getUsername(), "***", newQuiz.getUser().getEmail());
			
			newQuiz.setCategory(null);
			newQuiz.setUser(user);
			newQuiz.setHighScores(null);
			newQuiz.setQuestions(null);
		}
			return new ResponseEntity<>(newQuiz, HttpStatus.OK);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Quiz addQuiz(@RequestBody Quiz Quiz, @RequestAttribute("principal") Principal principal) {
		Quiz newQuiz = quizService.addQuiz(Quiz, principal);
	
		
		return quizService.addQuiz(Quiz, principal);
	
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
