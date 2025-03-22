package com.test.tracking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.tracking.model.Login;
import com.test.tracking.model.Signup;
import com.test.tracking.repository.SignupRepository;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    SignupRepository signupRepository;

    @Override
    public Login checkLogin(Login login) {
        Optional<Signup> existUser = signupRepository.findAllByEmail(login.getUserId());

        if (existUser.isPresent()) {
            Signup newLogin = existUser.get();

            if (login.getPassword() != null && login.getPassword().equals(newLogin.getPassword())) {
                login.setStatus(1);
                login.setOccupation(newLogin.getOccupation());
            } else {
                login.setStatus(0);
            }
        } else {
            login.setStatus(0); 
        }
        return login;
    }
}