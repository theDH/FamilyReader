package com.techelevator.model.DAO.JDBC;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Session;
import com.techelevator.model.DAO.SessionDAO;

@Component
public class JDBCSessionDAO implements SessionDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCSessionDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void addSession(Session newSession) {

		String sqlInsertAddSession = "INSERT INTO session (people_book_id, date_of_reading, minutes_read, type_of_reading) VALUES "
				+ "(?, ?, ?, ?);";
		int readingType = 0;
		switch (newSession.getTypeOfReading()) {
		case "readaloudreader":
			readingType = 1;
			break;
		case "readaloudlistener":
			readingType = 2;
			break;
		case "listenedto":
			readingType = 3;
			break;
		case "readtoself":
			readingType = 4;
			break;
		default:
			break;
		}
		jdbcTemplate.update(sqlInsertAddSession, newSession.getPeopleBookId(), newSession.getDateOfReading(),
				newSession.getMinutesRead(), readingType);
	}

	@Override
	public List<Session> getListOfSessionsByPerson(long personId) {
		
		List<Session> listOfSession = new ArrayList<>();

		String sqlSearchGetListOfSessionByPerson = "Select * FROM session JOIN people ON people.people_id = session.people_book_id "
				+ "JOIN people_book ON people_book.people_id = people.people_id "
				+ "WHERE people.people_id = ? "
				+ "ORDER BY date_of_reading DESC LIMIT 10; ";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchGetListOfSessionByPerson, personId);
		while (results.next()) {
			Session theSession = mapRowToSession(results);
			listOfSession.add(theSession);
		}

		return listOfSession;
	}

	@Override
	public List<Session> getListOfSessionsByFamily(long familyId) {

		List<Session> sessionListByFamily = new ArrayList<>();

		String sqlSearchGetListByFamily = "Select * FROM session JOIN people_book ON people_book.people_book_id = session.people_book_id " 
				+"JOIN people ON people.people_id = people_book.people_id JOIN family ON family.family_id = people.family_id " 
				+"WHERE family.family_id = ? "
				+"ORDER BY date_of_reading DESC LIMIT 10; ";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchGetListByFamily, familyId);
		while (results.next()) {
			Session theSession = mapRowToThatSession(results);
			sessionListByFamily.add(theSession);
		}

		return sessionListByFamily;
	}

	private Session mapRowToThatSession(SqlRowSet results) {
		Session theSession = new Session();

		theSession.setId(results.getLong("session_id"));
		theSession.setPeopleBookId(results.getLong("people_book_id"));
		theSession.setDateOfReading((results.getDate("date_of_reading").toLocalDate()));
		theSession.setTypeOfReading(results.getString("type_of_reading"));
		theSession.setMinutesRead(results.getInt("minutes_read"));

		return theSession;
	}

	private Session mapRowToSession(SqlRowSet results) {
		Session theSession = new Session();

		theSession.setId(results.getLong("session_id"));
		theSession.setPeopleBookId(results.getLong("people_book_id"));
		theSession.setDateOfReading((results.getDate("date_of_reading").toLocalDate()));
		theSession.setTypeOfReading(results.getString("type_of_reading"));
		theSession.setMinutesRead(results.getInt("minutes_read"));

		return theSession;
	}

}
