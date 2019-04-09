package com.techelevator.model.DAO.JDBC;

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
	//add person - primary keys?
	public void addPerson(Person newPerson) {
		String sqlInsertPerson = "INSERT INTO people(people_id, account_id, name, is_parent, inactive) " +
				   "VALUES(?, ?, ?, ?, ?)";
		newPerson.setPeopleId(getNextPersonId());
		jdbcTemplate.update(sqlInsertPerson, newPerson.getPeopleId(), 
				newPerson.getAccountId(), newPerson.getName(), newPerson.isParent(), newPerson.isInactive());
	}

	@Override
	public void deletePerson(long personId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Person> getListOfPeopleInAccount(long accountId) {
		// TODO Auto-generated method stub
		return null;
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
		thePerson =new Person();
		thePerson.setAccountId();
		
	}

}
