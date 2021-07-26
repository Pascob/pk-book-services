package com.pascob.pkbookservices.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pascob.pkbookservices.domain.User;
import com.pascob.pkbookservices.request.UserRequest;
import com.pascob.pkbookservices.response.MessageResponse;
import com.pascob.pkbookservices.services.UserService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;
	
	
	
	
	@GetMapping
	public List<User> users(){
		return userService.findAll();
	}
	
	@PostMapping
	public ResponseEntity<?> registerUser(@Valid @RequestBody UserRequest userRequest){
		
		if(userService.existsByEmail(userRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already taken!"));
		}
		
		if(userService.existsByEmail(userRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}
		
		userService.save(userRequest);
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
}
