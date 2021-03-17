package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.demo.service.UserServices;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserServices userServices;
	
	@RequestMapping("/add/{userId}/{movieName}")
	public String addToFavorite(@PathVariable Integer userId, @PathVariable String movieName, Model model) {

		return "homePage";
	}
	@RequestMapping("/remove/{userId}/{movieName}")
	public String removeFromFavorite(@PathVariable Integer userId, @PathVariable String movieName, Model model) {

		return "homePage";
	}
	@RequestMapping("/favoriteList/{userId}")
	public String getFavoriteList(@PathVariable Integer userId, Model model) {
		
		return"";
	}
	}

	
