package com.test.tracking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.tracking.model.Signup;

@Service
public interface SignupService {

	Signup saveSignup(Signup signup);

	List<Signup> getSignup(Signup signup);

}
