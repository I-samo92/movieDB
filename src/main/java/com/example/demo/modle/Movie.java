package com.example.demo.modle;

import lombok.Setter;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table
public class Movie {
	
	@Id
	private int id ;
	private String original_title ;
	private String overview ;
	private String poster_path ;
	private Genre[] genres;
	
	
	public Movie() {
		}


	@Override
	public String toString() {
		return "Movie [id=" + id + ", original_title=" + original_title + ", overview=" + overview + ", genres="
				+ Arrays.toString(genres) + "]";
	}


}
