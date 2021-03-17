package com.example.demo.modle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
public class RequestToken {

	private Boolean success;
	
	private String request_token;
	
	@Override
	public String toString() {
		return "RequestToken [success=" + success + ", request_token=" + request_token + "]";
	}
}
