package com.techelevator.model.DAO.JDBC;

import java.time.LocalDate;
import java.util.List;

import com.techelevator.model.Competition;
import com.techelevator.model.Person;
import com.techelevator.model.DAO.CompetitionDAO;

public class JDBCCompetitionDAO implements CompetitionDAO{

	@Override
	public void addPersonToCompetition(Competition newCompetition, long personId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createNewCompetition(Competition newCompetition) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Competition> getListOfFinishedCompetitions(LocalDate todayDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Competition> getListOfActiveCompetitions(LocalDate todayDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> getListOfPeopleInCompetition(long competitionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Competition> getListOfCompetitionsByPerson(long personId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Competition updateCompetition(Competition competition) {
		// TODO Auto-generated method stub
		return null;
	}

}
