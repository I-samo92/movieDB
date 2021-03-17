package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modle.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServices {
	/*
	 * @Autowired User user;
	 */
	@Autowired
	private UserRepository userRepository;

	
	public void addFavorite(Integer userId, String movieName) {
		Optional<User> user = userRepository.findById(userId);

	}

	public void removeFavorite() {

	}

	public User getUserById(Integer id) {
		return userRepository.getOne(id);
	}


	
	private static final String CREATE_TOKEN_API="https://api.themoviedb.org/3/authentication/token/new?api_key=1c2132494934f65f54e4b5340b8c5f13";
	private static final String CREATE_SESSION_API="https://api.themoviedb.org/3/authentication/Session/new?api_key=1c2132494934f65f54e4b5340b8c5f13";


}
