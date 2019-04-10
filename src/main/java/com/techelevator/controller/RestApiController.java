package com.techelevator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.model.Signup;
import com.techelevator.model.User;
import com.techelevator.model.DAO.JDBC.JDBCFamilyDAO;
import com.techelevator.model.DAO.JDBC.JDBCUserDAO;

@RestController
public class RestApiController {
	
	@Autowired
	JDBCUserDAO userDAO;
	
	@Autowired
	JDBCFamilyDAO familyDAO;

	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping(path="/authenticate", method=RequestMethod.POST)
	public void authenticateLogin(@RequestBody User user) {
		System.out.println(user.getUserName());
		System.out.println(user.getPassword());
	}
	
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping(path="/signup", method=RequestMethod.POST)
	public void addNewUser(@RequestBody Signup signup) {
		long familyId = familyDAO.addFamily(signup);
		userDAO.saveUser(signup.getUserName(), signup.getPassword(), familyId);
	}
}
