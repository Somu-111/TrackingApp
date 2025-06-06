package com.test.tracking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.test.tracking.model.Signup;
import com.test.tracking.service.SignupService;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/signup")
public class SignupController {
	
	@Autowired
	SignupService signupService;
	
	@PostMapping("/save")
	public Signup saveSignup(@RequestBody Signup signup) {
	return signupService.saveSignup(signup);
	}
	
	@GetMapping("/get")
	public List<Signup> getSignup(@RequestBody Signup signup) {
	return signupService.getSignup(signup);
	}
	
}