package com.techelevator.model.DAO.JDBC;

import java.util.List;

import com.techelevator.model.Goal;
import com.techelevator.model.DAO.GoalDAO;

public class JDBCGoalDAO implements GoalDAO{

	@Override
	public void createNewGoal(Goal newGoal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addGoalToPerson(Goal newGoal, long personID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Goal> getListOfAllGoals(long personId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Goal> getListOfFinishedGoals(long personId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Goal> getListOfOpenGoals(long personId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Goal updateGoal(Goal goal) {
		// TODO Auto-generated method stub
		return null;
	}

}
