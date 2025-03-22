package com.test.tracking.service;

import org.springframework.stereotype.Service;

import com.test.tracking.model.Login;

@Service
public interface LoginService {

	Login checkLogin(Login login);

}
