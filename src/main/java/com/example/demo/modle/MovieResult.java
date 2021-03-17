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
public class MovieResult {

	private int page;
	private List<Movie> results;

	@Override
	public String toString() {
		return "MovieResult [page=" + page + ", movie=" + results + "]";
	}

	public MovieResult() {
		super();

	}
}
