package com.techelevator.model.DAO.JDBC;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.model.Family;
import com.techelevator.model.DAO.FamilyDAO;

public class JDBCFamilyDAO implements FamilyDAO{
	
	private JdbcTemplate jdbcTemplate;

	public JDBCFamilyDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public long addFamily(Family newFamily) {
		String sql = "INSERT INTO family (family_name) VALUES (?) RETURNING family_id";
		SqlRowSet id = jdbcTemplate.queryForRowSet(sql);
		id.next();
		long familyId = id.getLong(0);
		return familyId;	
	}

}
