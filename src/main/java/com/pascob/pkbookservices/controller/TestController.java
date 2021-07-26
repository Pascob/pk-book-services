package com.pascob.pkbookservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test/")
public class TestController {

	@GetMapping("admin")
	public String admin() {
		return "I am admin";
	}
	
	@GetMapping("user")
	public String user() {
		return "I am a simple user";
	}


}
