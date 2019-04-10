package com.techelevator.model.DAO.JDBC;

import java.time.LocalDate;
import java.util.List;

import com.techelevator.model.Competition;
import com.techelevator.model.Person;
import com.techelevator.model.DAO.CompetitionDAO;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCCompetitionDAO implements CompetitionDAO{

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCCompetitionDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void addPersonToCompetition(Competition newCompetition, long personId) {
		String query="INSERT INTO competition_people (people_id, competition_id) VALUES (?,?)";
		jdbcTemplate.update(query, personId, newCompetition.getCompetitionId());
	}

	@Override
	public void createNewCompetition(Competition newCompetition) {
		String insertNewCompetition="INSERT INTO competition (competition_id, name_of_competition, start_date, end_date, description, minutes_to_finish) VALUES (?,?,?,?,?,?)";
		jdbcTemplate.update(insertNewCompetition,newCompetition.getCompetitionId(),newCompetition.getNameOfCompetition(),newCompetition.getStartDate(),newCompetition.getEndDate(),newCompetition.getDescription(),newCompetition.getMinutesToFinish());
	}

	@Override
	public List<Competition> getListOfFinishedCompetitions(LocalDate todayDate) {
		List<Competition> finishedCompetitions = new ArrayList<Competition>();
		String searchForFinishedCompetitions= "SELECT * FROM competition WHERE end_date < ?";
		SqlRowSet resutls=jdbcTemplate.queryForRowSet(searchForFinishedCompetitions, todayDate);
		while (results.next()) {
			Site competition = mapRowToCompetition(results);
			finishedCompetitions.add(competition);
		}
		return finishedCompetitions;
	}

	@Override
	public List<Competition> getListOfActiveCompetitions(LocalDate todayDate) {
		List<Competition> activeCompetitions = new ArrayList<Competition>();
		String getSqlOfActiveCompetitions = "SELECT * FROM competition WHERE ? BETWEEN start_date AND end_date";
		SqlRowSet results=jdbcTemplate.queryForRowSet(getSqlOfActiveCompetitions, todayDate);
		while (results.next()) {
			Site competition = mapRowToCompetition(results);
			activeCompetitions.add(competition);
		}
		return activeCompetitions;
	}

	@Override
	public List<Person> getListOfPeopleInCompetition(long competitionId) {
		List<Person> peopleInCompetitions = new ArrayList<Person>();
		String getSqlOfPeopleInCompetitions = "SELECT * FROM people JOIN people_id FROM competition_people ON people.people_id=competition.people_id WHERE competition_id = ?";
		SqlRowSet results=jdbcTemplate.queryForRowSet(getSqlOfPeopleInCompetitions, competitionId);
		while (results.next()) {
			Site people = mapRowToPerson(results);
			peopleInCompetitions.add(people);
		}
		return peopleInCompetition;
	}

	@Override
	public List<Competition> getListOfCompetitionsByPerson(long personId) {
		List<Person> competitionsByPerson = new ArrayList<Person>();
		String getSqlOfCompetitionsByPeople = "SELECT * FROM competition JOIN competition_people ON competition.competition_id=competition_people.competition_id WHERE people_id = ?";
		SqlRowSet results=jdbcTemplate.queryForRowSet(getSqlOfCompetitionsByPeople, personId);
		while (results.next()) {
			Site competition = mapRowToCompetition(results);
			competitionsByPerson.add(competition);
		}
		return competitionsByPerson;
	}

	@Override
	public Competition updateCompetition(Competition competition) {
		

	}

	private Competition mapRowToCompetition(SqlRowSet results) {
		Competition competition = new Competition();
		competition.setCompetitionId(results.getlong("competition_id"))
		competition.setNameOfCompetition(results.getString("name_of_competition"));
		competition.setStartDate(results.getLocalDate("start_date"));
		competition.setEndDate(results.getLocalDate("end_date"));
		competition.setDescription(results.getString("description"));
		competition.setMinutesToFinish(results.getInt("minutes_to_finish"));
		return competition;
	}
	private Person mapRowToPerson(SqlRowSet results) {
		Person person = new Person();
		person.setPeopleId(results.getString("people_id"));
		person.setAccountId(results.getInt("account_id"));
		person.setName(results.getString("name"));
		person.setParent(results.getBoolean("is_parent"));
		person.setInactive(results.getBoolean("inactive"));
		return Person;
	}
}
