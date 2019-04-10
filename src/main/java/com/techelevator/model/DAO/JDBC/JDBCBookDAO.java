package com.techelevator.model.DAO.JDBC;

import java.util.ArrayList;
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
	public void addBookToPerson(Book book, long personId) {
		String sql = "INSERT INTO people_book (id, book_id, people_id) " +
					"VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, getNextPeopleBookId(), book.getBookId(), personId);
	}

	@Override
	public List<Book> getListOfBooksByPerson(long personId) {
		ArrayList<Book> books = new ArrayList<Book>();
		String sql = "SELECT * FROM book JOIN people_book ON people_book.book_id = book.book_id " +
				"WHERE people_book.people_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, personId);
		while(results.next()) {
			Book book = mapRowToBook(results);
			books.add(book);
		}
		return books;
	}

	@Override
	public List<Book> getListOfBooksByFamily(long familyId) {
		ArrayList<Book> books = new ArrayList<Book>();
		String sql = "SELECT * FROM book JOIN people_book ON people_book.book_id = book.book_id " + 
				"JOIN people ON people.people_id = people_book.people_id " + 
				"JOIN family ON people.family_id = family.family_id " + 
				"WHERE people_book.people_id = ?; LIMIT 10";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, familyId);
		while(results.next()) {
			Book book = mapRowToBook(results);
			books.add(book);
		}
		return books;
	}

	@Override
	public void addNewBook(Book newBook) {
		String sql = "INSERT INTO book (book_id, title, author_first, author_last, " +
				"illustrator_first, illustrator_last, book_type, isbn) " +
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		newBook.setBookId(getNextBookId());
		jdbcTemplate.update(sql, newBook.getBookId(), newBook.getTitle(), newBook.getAuthorFirstName(),
				newBook.getAuthorLastName(), newBook.getIllustratorFirstName(), newBook.getIllustratorLastName(),
				newBook.getBookType(), newBook.getIsbn());
	}
	
	
	private long getNextBookId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('book_book_id_seq')");
		if(nextIdResult.next()) {
			return nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new book");
		}
	}
	
	private long getNextPeopleBookId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('people_book_id_seq')");
		if(nextIdResult.next()) {
			return nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new book");
		}
	}
	

	
	private Book mapRowToBook(SqlRowSet results) {
		Book book = new Book();
		book.setBookId(results.getLong("book_id"));
		book.setTitle(results.getString("title"));
		book.setAuthorFirstName(results.getString("author_first"));
		book.setAuthorLastName(results.getString("author_last"));
		book.setIllustratorFirstName(results.getString("illustrator_first"));
		book.setIllustratorLastName(results.getString("illustrator_last"));
		book.setBookType(results.getInt("book_type"));
		book.setIsbn(results.getInt("isbn"));
		return book;
	}

}
