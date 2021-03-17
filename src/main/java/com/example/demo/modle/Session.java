package com.example.demo.modle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Session {

	private String session_id;
	
	@Override
	public String toString() {
		return "Session [session_id=" + session_id + "]";
	}
}
