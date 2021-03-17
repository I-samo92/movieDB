package com.example.demo.utils;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.example.demo.modle.Movie;
import com.example.demo.modle.RequestToken;
import com.example.demo.modle.Session;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class Utils {
	

	public String createSearchURL(String movieName) {
		return "https://api.themoviedb.org/3/search/movie?api_key=1c2132494934f65f54e4b5340b8c5f13&language=en-US&query="
				+ movieName + "&page=1&include_adult=false";
	}

	public String createMovieDetailsURL(Integer movieId) {
		return "https://api.themoviedb.org/3/movie/" + movieId
				+ "?api_key=1c2132494934f65f54e4b5340b8c5f13&language=en-US";
	}

	public String CreateRequestToken() {

		return "";
	}

	@RequestMapping("/createSession")
	public String creatSession(String requestToken) throws Exception {
		var values = new HashMap<String, String>() {
			{
				put("request_token", "API Key");

			}
		};
		var objectMapper = new ObjectMapper();
		String requestBody = objectMapper.writeValueAsString(values);

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(CREATE_SESSION_WITH_LOGIN))
				.POST(HttpRequest.BodyPublishers.ofString(requestBody)).build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response);
		ObjectMapper mapper = new ObjectMapper();
		Session session = mapper.readValue(response.body(), Session.class);
		System.out.println(session.getSession_id());
		return session.getSession_id();
	}

	public String createANAPIToken() throws Exception {
				HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(CREATE_TOKEN_API)).build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		ObjectMapper mapper = new ObjectMapper();
		RequestToken requestToken = mapper.readValue(response.body(), RequestToken.class);

		return requestToken.getRequest_token();
	}

	/*
	 * public String validateWithLogin() throws Exception {
	 * 
	 * }
	 */
	
	
	
	
	private static final String CREATE_TOKEN_API = "https://api.themoviedb.org/3/authentication/token/new?api_key=1c2132494934f65f54e4b5340b8c5f13";
	private static final String VALIDATE_WITH_LOGIN_API = "https://api.themoviedb.org/3/authentication/token/validate_with_login?api_key=1c2132494934f65f54e4b5340b8c5f13";
	private static final String CREATE_SESSION_WITH_LOGIN = "https://api.themoviedb.org/3/authentication/Session/new?api_key=1c2132494934f65f54e4b5340b8c5f13";

	private static final String USERNAME = "sam.92";
	private static final String PASSWORD = "Samo9588";
}
