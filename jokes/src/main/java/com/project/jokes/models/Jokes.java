package com.project.jokes.models;

import java.util.List;

public class Jokes {
	
	private List<Joke> jokes;

	public Jokes() {
		super();
	}	

	public Jokes(List<Joke> jokes) {
		super();
		this.jokes = jokes;
	}

	public List<Joke> getJokes() {
		return jokes;
	}

	public void setJokes(List<Joke> jokes) {
		this.jokes = jokes;
	}

	@Override
	public String toString() {
		return "Jokes [jokes=" + jokes + "]";
	}
	
	
	
	

}
