package com.techelevator.model.DAO;

import java.util.List;

import com.techelevator.model.Goal;

public interface GoalDAO {
	
	public void createNewGoal(Goal newGoal);
	
	public void addGoalToPerson(Goal newGoal, long personID);
	
	public List<Goal> getListOfAllGoals(long personId);
	
	public List<Goal> getListOfFinishedGoals (long personId);
	
	public List<Goal> getListOfOpenGoals (long personId);
	
	public Goal updateGoal(Goal goal);

}