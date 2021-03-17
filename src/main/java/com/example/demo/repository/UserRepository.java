package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modle.User;



public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findById(Integer id);

}
