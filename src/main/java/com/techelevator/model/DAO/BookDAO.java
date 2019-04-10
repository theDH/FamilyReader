package com.techelevator.model.DAO;

import java.util.List;

import com.techelevator.model.Book;

public interface BookDAO {
	
	public void addNewBook(Book newBook);
	
	public void addBookToPerson(Book book, long personId);
	
	public List<Book> getListOfBooksByPerson(long personId);
	
	public List<Book> getListOfBooksByAccount(long accountId);

}
