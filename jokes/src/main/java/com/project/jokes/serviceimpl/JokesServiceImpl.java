package com.project.jokes.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.jokes.JokesConfigConstants;
import com.project.jokes.exception.OutOfRangeException;
import com.project.jokes.models.Joke;
import com.project.jokes.models.Jokes;

@Service
public class JokesServiceImpl {
	
	@Autowired
	private JokesConfigConstants jokesConfigConstants;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ObjectMapper ObjMapper;
	
	public Jokes getJokes(Integer count) throws JsonMappingException, JsonProcessingException {
		Jokes jokes = new Jokes();
		List<Joke> jokeList = new ArrayList<Joke>();

		if (count > 100) {
			throw new OutOfRangeException("you can get no more than 100 jokes at a time");
		} else if (count == 1) {
			jokeList.add(getJoke());
			jokes.setJokes(jokeList);
		} else {
			int counter = count / 10;
			int remainder  = count % 10;
			counter = remainder == 0 ? counter : counter + 1;

			for (int i = 1; i <= counter; i++) {
				if (i == counter && remainder !=0) {
					jokeList.addAll(getJokesInBatches().subList(0, remainder));
				} else {
					jokeList.addAll(getJokesInBatches());
				}
			}
			jokes.setJokes(jokeList);
		}
		return jokes;
	}

	
	private Joke getJoke() throws JsonMappingException, JsonProcessingException {
		String uri = jokesConfigConstants.getHost() + "/random_joke";
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, null, String.class);
		Joke  joke = ObjMapper.readValue(result.getBody(), Joke.class);
		return joke;
	}

	
	private List<Joke> getJokesInBatches() throws JsonMappingException, JsonProcessingException {
		String uri = jokesConfigConstants.getHost() + "/random_ten";
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, null, String.class);
		List<Joke>  jokes = ObjMapper.readValue(result.getBody(), List.class);
		return jokes;
	}

	
}
