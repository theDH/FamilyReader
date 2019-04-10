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
		jdbcTemplate.update(query, personId, extracted(newCompetition).getCompetitionId());
	}

	@Override
	public void createNewCompetition(Competition newCompetition) {
		String insertNewCompetition="INSERT INTO competition (competition_id, name_of_competition, start_date, end_date, description, minutes_to_finish) VALUES (?,?,?,?,?,?)";
		jdbcTemplate.update(insertNewCompetition,extracted(newCompetition).getCompetitionId(),extracted(newCompetition).getNameOfCompetition(),extracted(newCompetition).getStartDate(),extracted(newCompetition).getEndDate(),extracted(newCompetition).getDescription(),extracted(newCompetition).getMinutesToFinish());
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
	
		return null;
	}

	@Override
	public List<Competition> getListOfCompetitionsByPerson(long personId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Competition updateCompetition(Competition competition) {
		
		return null;
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
}
