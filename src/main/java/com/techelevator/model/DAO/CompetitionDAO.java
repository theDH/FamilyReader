package com.techelevator.model.DAO;

import java.time.LocalDate;
import java.util.List;

import com.techelevator.model.Competition;
import com.techelevator.model.Person;

public interface CompetitionDAO {
	
	public void addPersonToCompetition(Competition newCompetition, long personId);
	
	public void createNewCompetition(Competition newCompetition);
	
	public List<Competition> getListOfFinishedCompetitions(LocalDate todayDate);
	
	public List<Competition> getListOfActiveCompetitions(LocalDate todayDate, long familyId);
	
	public List<Person> getListOfPeopleInCompetition(long competitionId);
	
	public List<Competition> getListOfCompetitionsByPerson(long personId);
	
	public void updateCompetition(Competition competition);
	
	public Competition showCompetitionDetails(long competitionId);
	
	
}
