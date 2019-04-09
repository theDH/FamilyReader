package com.techelevator.model.DAO;

import java.util.List;

import com.techelevator.model.Competition;
import com.techelevator.model.Person;

public interface CompetitionDAO {
	
	public void addCompetitionToPerson(Competition newCompetition, long personId);
	
	public void createNewCompetition(Competition newCompetition);
	
	public List<Person> getListOfPeopleInCompetition(long competitionId);
	
	public List<Competition> getListOfCompetitionsByPerson(long personId);
	
	
}
