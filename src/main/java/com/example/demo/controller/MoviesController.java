package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.example.demo.modle.Movie;
import com.example.demo.modle.MovieResult;
import com.example.demo.modle.User;
import com.example.demo.service.UserServices;
import com.example.demo.utils.Utils;

@Controller
@RequestMapping("/movies")
public class MoviesController {

	private RestTemplate restTemplate;
	@Autowired
	private Utils utils;
	User user;
	@Autowired
	UserServices userServices;

	@GetMapping("/latest")
	public String getLatestMovies(Model model) throws Exception {

		restTemplate = new RestTemplate();
		MovieResult movieResult = new MovieResult();
		user= new User();
		user=userServices.getUserById(1);
		movieResult = restTemplate.getForObject(LATEST_MOVIE_API, MovieResult.class);
		model.addAttribute("movies", movieResult.getResults());
		model.addAttribute("user", user);
		
		return "homePage";
	}

	@RequestMapping("/search")
	public String searchMovie(@RequestParam(value = "movieName", required = true) String movieName, Model model) {

		restTemplate = new RestTemplate();
		MovieResult	movieResult = new MovieResult();
		user= new User();
		user=userServices.getUserById(1);
		movieResult = restTemplate.getForObject(utils.createSearchURL(movieName), MovieResult.class);
		model.addAttribute("movies", movieResult.getResults());
		model.addAttribute("user", user);
		
		return "searchResultPage";
	}

	@RequestMapping("/details/{id}")
	public String MovieDetails(@PathVariable Integer id, Model model) {
		restTemplate = new RestTemplate();
		StringBuilder genres = new StringBuilder("");
		user= new User();
		
		user=userServices.getUserById(1);
		Movie movie = new Movie();
		
		movie = restTemplate.getForObject(utils.createMovieDetailsURL(id), Movie.class);
		for (int i = 0; i < movie.getGenres().length; i++) {
			if (i != movie.getGenres().length - 1)
				genres.append(movie.getGenres()[i].getName() + " ,");
			else
				genres.append(movie.getGenres()[i].getName() + " .");
		}
		model.addAttribute("movies", movie);
		model.addAttribute("Genres", genres);
		model.addAttribute("user", user);
		return "movieDetails";
	}

	private static final String LATEST_MOVIE_API = "https://api.themoviedb.org/3/trending/movie/day?api_key=1c2132494934f65f54e4b5340b8c5f13";

}
