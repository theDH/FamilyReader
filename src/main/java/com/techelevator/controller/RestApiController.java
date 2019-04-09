package com.techelevator.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.model.DAO.UserDAO;

@RestController
public class RestApiController {

	private UserDAO userDAO;

	@Autowired
	public RestApiController(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@RequestMapping(path="/authenticate", method=RequestMethod.POST)
	public void displayLoginForm(@RequestParam String userName, @RequestParam String password) {
		System.out.println(userName);
		System.out.println(password);
	}
	

	@RequestMapping(path="/logout", method=RequestMethod.POST)
	public String logout(ModelMap model, HttpSession session) {
		model.remove("currentUser");
		session.invalidate();
		return "redirect:/";
	}
}
