package com.techelevator.model.DAO.JDBC;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.model.Person;
import com.techelevator.model.DAO.PersonDAO;

public class JDBCPersonDAO implements PersonDAO{
	
	private JdbcTemplate jdbcTemplate;
	
	public JDBCPersonDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void addPerson(Person newPerson) {
		String sqlInsertPerson = "INSERT INTO people(people_id, account_id, name, is_parent, inactive) " +
				   "VALUES(?, ?, ?, ?, ?)";
		newPerson.setPeopleId(getNextPersonId());
		jdbcTemplate.update(sqlInsertPerson, newPerson.getPeopleId(), 
				newPerson.getAccountId(), newPerson.getName(), newPerson.isParent(), newPerson.isInactive());
	}

	@Override
	public void deletePerson(long personId) {
		String sqlDelete = "DELETE FROM people WHERE id = ?;";
		jdbcTemplate.update(sqlDelete, personId);
		
	}

	@Override
	public List<Person> getListOfPeopleInAccount(long accountId) {
	ArrayList<Person> persons = new ArrayList<Person>();
	String sql = "SELECT * FROM people JOIN account ON people.account_id = account.account_id" +
	"WHERE people.account_id =?; ";
	SqlRowSet results = jdbcTemplate.queryForRowSet(sql, accountId);
	while (results.next()) {
		Person person = mapRowToPerson(results);
		persons.add(person);
	}
		return persons;
	}
	
	private long getNextPersonId() {
		SqlRowSet nextPersonResult = jdbcTemplate.queryForRowSet("SELECT nextval('people_people_id_seq')");
		if(nextPersonResult.next()) {
			return nextPersonResult.getLong(1);
		}else {
			throw new RuntimeException("Something went wrong while getting new person id.");
		}
		
	}
	
	private Person mapRowToPerson(SqlRowSet results) {
		Person thePerson;
		thePerson = new Person();
		thePerson.setPeopleId(results.getLong("people_id"));
		thePerson.setAccountId(results.getLong("account_id"));
		thePerson.setName(results.getString("name"));
		thePerson.setInactive(results.getBoolean("inactive"));
		thePerson.setParent(results.getBoolean("is_parent"));
		return thePerson;
	}

}
