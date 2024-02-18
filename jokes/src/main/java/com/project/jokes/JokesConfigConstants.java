package com.project.jokes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JokesConfigConstants {

	@Value("${jokes.host}")
	private String host;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}
	
	
	
}
