package com.techelevator.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApiController {

	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping(path="/authenticate", method=RequestMethod.POST)
	public void authenticateLogin(@RequestParam String userName, @RequestParam String password) {
		System.out.println(userName);
		System.out.println(password);
	}
	
	@RequestMapping(path="/signup", method=RequestMethod.POST)
	public void addNewUser(@RequestParam String familyName, @RequestParam String userName, @RequestParam String password) {
		System.out.println(familyName);
		System.out.println(userName);
		System.out.println(password);
	}
}
