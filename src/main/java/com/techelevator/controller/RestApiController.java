package com.techelevator.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.model.Book;
import com.techelevator.model.Competition;
import com.techelevator.model.Goal;
import com.techelevator.model.Person;
import com.techelevator.model.Signup;
import com.techelevator.model.User;
import com.techelevator.model.DAO.BookDAO;
import com.techelevator.model.DAO.CompetitionDAO;
import com.techelevator.model.DAO.FamilyDAO;
import com.techelevator.model.DAO.GoalDAO;
import com.techelevator.model.DAO.PersonDAO;
import com.techelevator.model.DAO.UserDAO;


@RestController
public class RestApiController {
	
	private UserDAO userDAO;
	private FamilyDAO familyDAO;
	private BookDAO bookDAO;
	private PersonDAO personDAO;
	private GoalDAO goalDAO;
	private CompetitionDAO competitionDAO;
	
	@Autowired
	public RestApiController(UserDAO userDAO, FamilyDAO familyDAO, BookDAO bookDAO, PersonDAO personDAO, GoalDAO goalDAO, CompetitionDAO competitionDAO) {
		this.userDAO = userDAO;
		this.familyDAO = familyDAO;
		this.bookDAO = bookDAO;
		this.personDAO = personDAO;
		this.goalDAO = goalDAO;
		this.competitionDAO = competitionDAO;
	}
	
	
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping(path="/authenticate", method=RequestMethod.POST)
	public Long authenticateLogin(@RequestBody User user) {
		if(userDAO.searchForUsernameAndPassword(user.getUserName(), user.getPassword())) {
			return userDAO.getFamilyByUser(user);
		} else {
			return null;
		}
	}
	
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping(path="/signup", method=RequestMethod.POST)
	public void addNewUser(@RequestBody Signup signup) {
		long familyId = familyDAO.addFamily(signup);
		userDAO.saveUser(signup.getUserName(), signup.getPassword(), familyId);
		
	}
	
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping(path="/bookList", method=RequestMethod.GET)
	public List<Book> getListOfBooks(@RequestParam long personId){
		return bookDAO.getListOfBooksByPerson(personId);
	}
	
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping(path="/bookListByFamily", method=RequestMethod.GET)
	public List<Book> getListOfBooksByFamily(@RequestParam long familyId){
		return bookDAO.getListOfBooksByFamily(familyId);
	}
	
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping(path="bookdetail", method=RequestMethod.GET)
	public Book getBookDetail() {
		return bookDAO.getBookDetail(1);
	}
	
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping(path="familylist", method=RequestMethod.GET)
	public List<Person> getFamilyList(@RequestParam long familyId){
		return personDAO.getListOfPeopleInFamily(familyId);
		}
	
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping(path="goaldetail", method=RequestMethod.GET)
	public Goal getGoalDetail() {
		return goalDAO.getGoalDetail(1);
	}
	

//	@CrossOrigin(origins = "http://localhost:8081")
//	@RequestMapping(path="competitiondetail", method=RequestMethod.GET)
//	public Competition getCompetitionDetail() {
//		return competitionDAO.getCompetitionDetail(1);
//	}
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping(path="competitionlista", method=RequestMethod.GET)
	public List<Competition> getListOfActiveCompetitions(@RequestParam LocalDate todayDate, long familyId) {
		return competitionDAO.getListOfActiveCompetitions(todayDate, familyId);
	}
	
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping(path="competitionlist", method=RequestMethod.GET)
	public List<Person> getListOfPeopleInCompetition(@RequestParam long competitionId) {
		return competitionDAO.getListOfPeopleInCompetition(competitionId);
	}
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping(path="/homepage", method=RequestMethod.GET)
	public void homepage() {
		

	}
}
