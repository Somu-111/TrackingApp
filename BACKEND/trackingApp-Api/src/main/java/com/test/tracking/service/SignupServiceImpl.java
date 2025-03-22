package com.test.tracking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.tracking.model.Signup;
import com.test.tracking.repository.SignupRepository;

@Service
public class SignupServiceImpl implements SignupService{

	@Autowired
	SignupRepository signupRepository;
	
	@Override
	public Signup saveSignup(Signup signup) {
		return signupRepository.save(signup);
	}

	@Override
	public List<Signup> getSignup(Signup signup) {
		
		return signupRepository.findAll();
	}

}
