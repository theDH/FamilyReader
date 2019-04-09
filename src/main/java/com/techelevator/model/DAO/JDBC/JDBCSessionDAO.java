package com.techelevator.model.DAO.JDBC;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.model.Session;
import com.techelevator.model.DAO.SessionDAO;

public class JDBCSessionDAO implements SessionDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCSessionDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void addSession(Session newSession) {

		String sqlInsertAddSession = "INSERT INTO session (people_book_id, date_reading, minutes_read, type_of_reading) Values "
				+ "?, ?, ?, ? ";

		jdbcTemplate.update(sqlInsertAddSession, newSession.getPeople_book_id(), newSession.getDateOfReading(),
				newSession.getMinutesRead(), newSession.getTypeOfReading());

	}

	@Override
	public List<Session> getListOfSessionsByPerson(long personId) {
		// TODO Auto-generated method stub
		List<Session> listOfSession = new ArrayList<>();

		String sqlSearchGetListOfSessionByPerson = "Select * FROM session JOIN session ON session.people_book_id = people_book.people_book_id "
				+ "JOIN people_book ON people_book.people_id = people.people_id WHERE people.people_id = ?";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchGetListOfSessionByPerson, personId);
		while (results.next()) {
			Session theSession = mapRowToSession(results);
			listOfSession.add(theSession);
		}

		return listOfSession;
	}

	@Override
	public List<Session> getListOfSessionsByAccount(long accountId) {

		List<Session> sessionListByAccount = new ArrayList<>();

		String sqlSearchGetListByAccount = "Select * FROM session JOIN people_book ON people_book.people_book_id = session.people_book_id "
				+ "JOIN people ON people.people_id = people_book.people_id JOIN account ON account.account_id = people.account_id "
				+ "WHERE account_id = ?";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchGetListByAccount, accountId);
		while (results.next()) {
			Session theSession = mapRowToThatSession(results);
			sessionListByAccount.add(theSession);
		}

		return sessionListByAccount;
	}

	private Session mapRowToThatSession(SqlRowSet results) {
		Session theSession = new Session();

		theSession.setId(results.getLong("id"));
		theSession.setPeople_book_id(results.getLong("people_book_id"));
		theSession.setDateOfReading((results.getDate("date_of_reading").toLocalDate()));
		theSession.setTypeOfReading(results.getString("type_of_reading"));
		theSession.setMinutesRead(results.getInt("minutes_read"));
		theSession.setName(results.getString("name"));

		return theSession;
	}

	private Session mapRowToSession(SqlRowSet results) {
		// TODO Auto-generated method stub
		Session theSession = new Session();

		theSession.setId(results.getLong("id"));
		theSession.setPeople_book_id(results.getLong("people_book_id"));
		theSession.setDateOfReading((results.getDate("date_of_reading").toLocalDate()));
		theSession.setTypeOfReading(results.getString("type_of_reading"));
		theSession.setMinutesRead(results.getInt("minutes_read"));

		return theSession;
	}

}
