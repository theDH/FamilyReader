package com.techelevator.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApiController {

	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping(path="/authenticate", method=RequestMethod.POST)
	public void authenticateLogin(@RequestBody String loginRequest) {
		System.out.println(loginRequest);
	}
	
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping(path="/signup", method=RequestMethod.POST)
	public void addNewUser(@RequestBody String signupRequest) {
		System.out.println(signupRequest);
	}
}
