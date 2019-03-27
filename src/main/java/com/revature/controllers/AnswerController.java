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

import com.revature.dtos.AnswerDTO;
import com.revature.exceptions.ObjectErrorResponse;
import com.revature.exceptions.ObjectNotFoundException;
import com.revature.models.Answer;
import com.revature.models.Principal;
import com.revature.services.AnswerService;

@RestController
@RequestMapping("/answer")
public class AnswerController {

	private AnswerService ansService;
	
	@Autowired
	public AnswerController(AnswerService aService) {
		ansService = aService;
	}
	
	@GetMapping(value = "/ques/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Answer> getAnsByQuesId(@PathVariable int id) {

		List<Answer> answers = ansService.getAnswerByQuestionId(id);
		
		if(answers.isEmpty()) throw new ObjectNotFoundException("No answer with question id: " + id + " found");
		
		for (Answer ans : answers)ans.setQuestion(null);

		return answers;
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Answer addAnswer(@RequestBody AnswerDTO newAnswer, @RequestAttribute("principal") Principal principal) {
		
		Answer addingAns = new Answer(0, newAnswer.getAnswer(), newAnswer.getAnswerId());
			
		return ansService.addAnswer(addingAns, principal);
	}
	
	@PatchMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<Answer> updateAnswer(@RequestBody Answer updatedAnswer) {
		Answer respAns = ansService.updateAnswer(updatedAnswer);
		
		if (respAns == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else {
			respAns.setQuestion(null);
		}
			return new ResponseEntity<>(respAns, HttpStatus.OK);
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
