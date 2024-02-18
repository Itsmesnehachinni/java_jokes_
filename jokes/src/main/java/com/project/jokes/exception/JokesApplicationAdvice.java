package com.project.jokes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class JokesApplicationAdvice {
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	private ErrorOutput handleException(OutOfRangeException ex) {
		ErrorOutput error = new ErrorOutput();
		error.setMessage(ex.getMessage());
		return error;
	}

}
