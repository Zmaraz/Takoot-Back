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

import com.revature.exceptions.ObjectErrorResponse;
import com.revature.exceptions.ObjectNotFoundException;
import com.revature.models.HighScore;
import com.revature.models.Principal;
import com.revature.services.HighScoreService;

@RestController
@RequestMapping("/high-score")
public class HighScoreController {

	private HighScoreService highService;
	
	@Autowired
	public HighScoreController(HighScoreService hsServe) {
		highService = hsServe;
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<HighScore> getAllHighScores() {

		List<HighScore> scores = highService.getAllHighScores();

		for (HighScore hs : scores) {

			hs.setQuiz(null);
			hs.setUser(null);

		}

		return scores;
	}
	
	@GetMapping(value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<HighScore> getScoresByUserId(@PathVariable int id) {

		List<HighScore> scores = highService.getScoresByUserId(id);
		
		if(scores.isEmpty()) throw new ObjectNotFoundException("No scores are registered user yet.");
		
		for (HighScore hs : scores) {

			hs.setQuiz(null);
			hs.setUser(null);

		}
		 
		return scores;
	}
	
	@GetMapping(value = "/quiz/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<HighScore> getHighScoresByQuizId(@PathVariable int id) {

		List<HighScore> scores = highService.getScoresByQuizId(id);
		
		if(scores.isEmpty()) throw new ObjectNotFoundException("No scores are this quiz yet.");
		
		for (HighScore hs : scores) {

			hs.setQuiz(null);
			hs.setUser(null);

		}
		 
		return scores;
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public HighScore addScore(@RequestBody HighScore newScore, @RequestAttribute("principal") Principal principal, @RequestAttribute("quizId") int quizId) {
		HighScore respScore = highService.addHighScore(newScore, principal, quizId);
				
		respScore.setQuiz(null);
		respScore.setUser(null);
				
		return respScore;
	}
	
	@PatchMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<HighScore> updateHighScores(@RequestBody HighScore updatedScore) {
		HighScore respScore = highService.updateHighScore(updatedScore);
		
		if (respScore == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else {
			respScore.setQuiz(null);
			respScore.setUser(null);
		}
			return new ResponseEntity<>(respScore, HttpStatus.OK);
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
