package com.techelevator.model.DAO.JDBC;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.model.Book;
import com.techelevator.model.DAO.BookDAO;

public class JDBCBookDAO implements BookDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public JDBCBookDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void addBookToPerson(long personId) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Book> getListOfBooksByPerson(long personId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getListOfBooksByAccount(long accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addNewBook(Book newBook) {
		String sql = "INSERT INTO book (book_id, title, author_first, author_last, " +
				"illustrator_first, illustrator_last, book_type, isbn) " +
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		
	}
	
	
	private long getNextBookId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_city_id')");
		if(nextIdResult.next()) {
			return nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new book");
		}
	}

}
