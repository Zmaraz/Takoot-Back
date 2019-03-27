package com.revature.controllers;

import java.util.List;

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

import com.revature.dtos.QuestionDTO;
import com.revature.exceptions.ObjectErrorResponse;
import com.revature.exceptions.ObjectNotFoundException;
import com.revature.models.Principal;
import com.revature.models.Question;
import com.revature.services.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {

	private QuestionService quesService;

	@Autowired
	public QuestionController(QuestionService qService) {
		quesService = qService;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Question> getAllQuestions() {

		List<Question> initialQuestions = quesService.getAllQuestions();

		return initialQuestions;
	}

	@GetMapping(value = "/quiz/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Question> getQuesByQuizId(@PathVariable int id) {

		List<Question> questions = quesService.getAllQuestionsByQuizId(id);
		
		if(questions.isEmpty()) throw new ObjectNotFoundException("No question with quiz id: " + id + " found");
				 
		return questions;
	}
	
	@PatchMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<Question> updateQuestion(@RequestBody Question updatedQuestion) {
		Question respQues = quesService.updateQuestion(updatedQuestion);
		
		if (respQues == null)return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
			return new ResponseEntity<>(respQues, HttpStatus.OK);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Question addQuestion(@RequestBody QuestionDTO newQuestion, @RequestAttribute("principal") Principal principal) {
		Question addingQues = new Question(0, newQuestion.getQuestion());		
				
		return quesService.addQuestion(addingQues, principal);
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
