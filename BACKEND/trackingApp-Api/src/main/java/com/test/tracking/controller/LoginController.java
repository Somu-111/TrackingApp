
package com.test.tracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.tracking.model.Login;
import com.test.tracking.service.LoginService;


@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	LoginService loginService;
	
	@PostMapping("/checkLogin")
    public ResponseEntity<Login> checkLogin(@RequestBody Login login) {
        
        return new ResponseEntity<Login>(loginService.checkLogin(login),HttpStatus.CREATED);
    }

}
