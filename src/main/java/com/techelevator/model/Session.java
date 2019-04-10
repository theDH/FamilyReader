package com.techelevator.model;

import java.time.LocalDate;

public class Session {
	
	private long id;
	private LocalDate dateOfReading;
	private int minutesRead;
	private String typeOfReading;
	private long people_book_id;
	private String name;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPeople_book_id() {
		return people_book_id;
	}
	public void setPeople_book_id(long people_book_id) {
		this.people_book_id = people_book_id;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public LocalDate getDateOfReading() {
		return dateOfReading;
	}
	public void setDateOfReading(LocalDate dateOfReading) {
		this.dateOfReading = dateOfReading;
	}
	public int getMinutesRead() {
		return minutesRead;
	}
	public void setMinutesRead(int minutesRead) {
		this.minutesRead = minutesRead;
	}
	public String getTypeOfReading() {
		return typeOfReading;
	}
	public void setTypeOfReading(String typeOfReading) {
		this.typeOfReading = typeOfReading;
	}
	
	

}
