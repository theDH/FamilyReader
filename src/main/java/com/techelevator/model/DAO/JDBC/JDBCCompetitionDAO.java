package com.techelevator.model.DAO.JDBC;

import java.time.LocalDate;
import java.util.List;

import com.techelevator.model.Competition;
import com.techelevator.model.Person;
import com.techelevator.model.DAO.CompetitionDAO;

import javax.sql.DataSource;
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
		// TODO Auto-generated method stub
		String query="INSERT INTO competition_people (people_id, competition_id) VALUES (?,?)";
		jdbcTemplate.update(query, personId, newCompetition.getCompetitionId());
	}

	@Override
	public void createNewCompetition(Competition newCompetition) {
		// TODO Auto-generated method stub
		String query="INSERT INTO competition (competition_id, name_of_competition, start_date, end_date, description, minutes_to_finish) VALUES (?,?,?,?,?,?)";
		jdbcTemplate.update(query,newCompetition.getCompetitionId(),newCompetition.getNameOfCompetition(),newCompetition.getStartDate(),newCompetition.getEndDate(),newCompetition.getDescription(),newCompetition.getMinutesToFinish());
		
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
