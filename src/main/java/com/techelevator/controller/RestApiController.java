package com.techelevator.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.model.User;

@RestController
public class RestApiController {

	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping(path="/authenticate", method=RequestMethod.POST)
	public void authenticateLogin(@RequestBody User user) {
		System.out.println(user.getUserName());
		System.out.println(user.getPassword());
	}
	
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping(path="/signup", method=RequestMethod.POST)
	public void addNewUser(@RequestBody String signupRequest) {
		System.out.println(signupRequest);
	}
}
