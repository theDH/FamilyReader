package com.techelevator.model;

import java.time.LocalDate;

public class Goal {
	
	private long goalId;
	private String nameOfGoal;
	private LocalDate startDate;
	private int numberOfDays;
	public int getMinutesRead() {
		return minutesRead;
	}
	public void setMinutesRead(int minutesRead) {
		this.minutesRead = minutesRead;
	}
	private String description;
	private int minutesToReachGoal;
	private int minutesRead;
	private boolean isComplete = false;
	
	
	public boolean isComplete() {
		return isComplete;
	}
	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}
	public long getGoalId() {
		return goalId;
	}
	public void setGoalId(long goalId) {
		this.goalId = goalId;
	}
	public String getNameOfGoal() {
		return nameOfGoal;
	}
	public void setNameOfGoal(String nameOfGoal) {
		this.nameOfGoal = nameOfGoal;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public int getNumberOfDays() {
		return numberOfDays;
	}
	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getMinutesToReachGoal() {
		return minutesToReachGoal;
	}
	public void setMinutesToReachGoal(int minutesToReachGoal) {
		this.minutesToReachGoal = minutesToReachGoal;
	}
	
	

}
