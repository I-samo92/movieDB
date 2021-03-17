package com.example.demo.modle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="User")
public class User {
	@Id
	@Column(unique = true, nullable = false)
	private Integer id ;
	
	@Column(length = 70,nullable = true)
	private String username ; 
	
	@Column(length = 70,nullable = true)
	private String password;
	
	}
