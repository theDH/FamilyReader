package com.techelevator.model;

public class Book {
	
	private long bookId;
	private String title;
	private String authorFirstName;
	private String authorLastName;
	private String illustratorFirstName;
	private String illustratorLastName;
	private int bookType;
	private long isbn;
	
	
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthorFirstName() {
		return authorFirstName;
	}
	public void setAuthorFirstName(String authorFirstName) {
		this.authorFirstName = authorFirstName;
	}
	public String getAuthorLastName() {
		return authorLastName;
	}
	public void setAuthorLastName(String authorLastName) {
		this.authorLastName = authorLastName;
	}
	public String getIllustratorFirstName() {
		return illustratorFirstName;
	}
	public void setIllustratorFirstName(String illustratorFirstName) {
		this.illustratorFirstName = illustratorFirstName;
	}
	public String getIllustratorLastName() {
		return illustratorLastName;
	}
	public void setIllustratorLastName(String illustratorLastName) {
		this.illustratorLastName = illustratorLastName;
	}
	public int getBookType() {
		return bookType;
	}
	public void setBookType(int bookType) {
		this.bookType = bookType;
	}
	public long getIsbn() {
		return isbn;
	}
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	

}
