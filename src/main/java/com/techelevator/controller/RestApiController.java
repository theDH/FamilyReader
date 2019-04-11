package com.techelevator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.model.Book;
import com.techelevator.model.Person;
import com.techelevator.model.Signup;
import com.techelevator.model.User;
import com.techelevator.model.DAO.BookDAO;
import com.techelevator.model.DAO.FamilyDAO;
import com.techelevator.model.DAO.PersonDAO;
import com.techelevator.model.DAO.UserDAO;
import com.techelevator.model.DAO.JDBC.JDBCFamilyDAO;
import com.techelevator.model.DAO.JDBC.JDBCUserDAO;

@RestController
public class RestApiController {
	
	private UserDAO userDAO;
	private FamilyDAO familyDAO;
	private BookDAO bookDAO;
	private PersonDAO personDAO;
	
	@Autowired
	public RestApiController(UserDAO userDAO, FamilyDAO familyDAO, BookDAO bookDAO, PersonDAO personDAO) {
		this.userDAO = userDAO;
		this.familyDAO = familyDAO;
		this.bookDAO = bookDAO;
		this.personDAO = personDAO;
	}
	
	
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
		System.out.println(familyId);
		userDAO.saveUser(signup.getUserName(), signup.getPassword(), familyId);
		
	}
	
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping(path="bookDetail", method=RequestMethod.GET)
	public Book getBookDetail() {
		return bookDAO.getBookDetail(1);
	}
	
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping(path="familyList", method=RequestMethod.GET)
	public List<Person> getFamilyList(@RequestParam long familyId){
		return personDAO.getListOfPeopleInFamily(familyId);
		}
}
