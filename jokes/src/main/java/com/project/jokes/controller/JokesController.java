package com.project.jokes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.project.jokes.models.Jokes;
import com.project.jokes.service.JokesService;

@RestController
@RequestMapping("/jokes")
public class JokesController {
	
	@Autowired
	private JokesService jokesService;
	
	
	@GetMapping
	private Jokes getJokes(@RequestParam(value = "count", required = false, defaultValue = "5") Integer count) throws JsonMappingException, JsonProcessingException {
		Jokes  output = new Jokes();
		output = this.jokesService.getJokes(count);
		return output;
	}

}
