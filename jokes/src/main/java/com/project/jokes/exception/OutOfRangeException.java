package com.project.jokes.exception;

public class OutOfRangeException extends RuntimeException {	

	private static final long serialVersionUID = 1137407409755491341L;
	
	private String message;
		
	public OutOfRangeException() {
		super();
	}
	
	public OutOfRangeException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
