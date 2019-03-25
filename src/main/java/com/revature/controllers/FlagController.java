package com.revature.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.exceptions.ObjectErrorResponse;
import com.revature.exceptions.ObjectNotFoundException;
import com.revature.models.Flag;
import com.revature.services.FlagService;

@RestController
@RequestMapping("/flag")
public class FlagController {

	private FlagService flagServ;
	
	@Autowired
	public FlagController(FlagService fServer) {
		flagServ = fServer;
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Flag getFlagByQuestionId(@PathVariable int id) {

		List<Flag> flags = flagServ.getFlagByQuestionId(id);
		
		Optional<Flag> flag = flags.stream().filter(fl -> fl.getQuestion().getQuestionId() == id).findFirst();
		
		if (flag.isPresent()) {
			System.out.println(flag);
			
			Flag respFlag = flag.get();
			
			respFlag.setQuestion(null);
			
			return respFlag;
		} else
			throw new ObjectNotFoundException("No flag with question id: " + id + " found");
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Flag addFlag(@RequestBody Flag newFlag) {
		Flag respFlag = flagServ.addFlag(newFlag);
				
		respFlag.setQuestion(null);
				
		return respFlag;
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