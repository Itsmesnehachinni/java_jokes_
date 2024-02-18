package com.project.jokes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.project.jokes.models.Jokes;
import com.project.jokes.serviceimpl.JokesServiceImpl;

@Service
public class JokesService {

	@Autowired
	private JokesServiceImpl jokesServiceImpl;

	public Jokes getJokes(Integer count) throws JsonMappingException, JsonProcessingException {
		return this.jokesServiceImpl.getJokes(count);
	}

}
