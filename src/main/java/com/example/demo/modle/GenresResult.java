package com.example.demo.modle;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@Component
public class GenresResult {

	private List<Genre> genres;

	@Override
	public String toString() {
		return "GenresResult [genres=" + genres + "]";
	}

	public GenresResult() {
		super();
	}

}
