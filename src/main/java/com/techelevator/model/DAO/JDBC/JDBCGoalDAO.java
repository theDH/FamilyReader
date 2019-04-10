package com.techelevator.model.DAO.JDBC;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.model.Goal;
import com.techelevator.model.DAO.GoalDAO;

public class JDBCGoalDAO implements GoalDAO{
	
	private JdbcTemplate jdbcTemplate;
	
	public JDBCGoalDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void createNewGoal(Goal newGoal) {
		String sql = "INSERT INTO goal (goal_id, name_of_goal, start_date, number_of_days, " +
				"description, minutes_to_reach_goal, is_complete) VALUES " +
				"(?, ?, ?, ?, ?, ?, ?)";
		newGoal.setGoalId(getNextGoalId());
		jdbcTemplate.update(sql, newGoal.getGoalId(), newGoal.getNameOfGoal(), newGoal.getStartDate(), 
				newGoal.getNumberOfDays(), newGoal.getDescription(), newGoal.getMinutesToReachGoal(), 
				newGoal.isComplete());
	}

	@Override
	public void addGoalToPerson(Goal newGoal, long personId) {
		String sql = "INSERT INTO goal_people (goal_id, people_id) " +
					"VALUES (?, ?)";
		jdbcTemplate.update(sql, newGoal.getGoalId(), personId);
	}

	@Override
	public List<Goal> getListOfAllGoals(long personId) {
		ArrayList<Goal> goals = new ArrayList<Goal>();
		String sql = "SELECT * FROM goals JOIN goal_people ON goal.goal_id = goal_people.goal_id WHERE " +
					"goal_people.people_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, personId);
		while(results.next()) {
			Goal goal = mapRowToGoal(results);
			goals.add(goal);
		}
		return goals;
	}

	@Override
	public List<Goal> getListOfFinishedGoals(long personId) {
		ArrayList<Goal> goals = new ArrayList<Goal>();
		String sql = "SELECT * FROM goals JOIN goal_people ON goal.goal_id = goal_people.goal_id WHERE " + 
				"goal_people.people_id = ? and goal.is_complete = true";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, personId);
		while(results.next()) {
			Goal goal = mapRowToGoal(results);
			goals.add(goal);
		}
		return goals;
	}

	@Override
	public List<Goal> getListOfOpenGoals(long personId) {
		ArrayList<Goal> goals = new ArrayList<Goal>();
		String sql = "SELECT * FROM goals JOIN goal_people ON goal.goal_id = goal_people.goal_id WHERE " + 
				"goal_people.people_id = ? and goal.is_complete = false";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, personId);
		while(results.next()) {
			Goal goal = mapRowToGoal(results);
			goals.add(goal);
		}
		return goals;
	}

	@Override
	public void updateGoal(Goal goal) {
		String sql = "UPDATE goal SET name_of_goal = ?, start_date = ?, number_of_days = ?, " +
					"description = ?, minutes_to_reach_goal = ?, is_complete = ?";
		jdbcTemplate.update(sql, goal.getNameOfGoal(), goal.getStartDate(), goal.getNumberOfDays(), 
				goal.getDescription(), goal.getMinutesToReachGoal(), goal.isComplete());
	}
	
	private long getNextGoalId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('goal_goal_id_seq')");
		if(nextIdResult.next()) {
			return nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new goal");
		}
	}
	
	private Goal mapRowToGoal(SqlRowSet results) {
		Goal goal = new Goal();
		goal.setGoalId(results.getLong("goal_id"));
		goal.setNameOfGoal(results.getString("name_of_goal"));
		goal.setStartDate(results.getDate("start_date").toLocalDate());
		goal.setNumberOfDays(results.getInt("number_of_days"));
		goal.setDescription(results.getString("description"));
		goal.setMinutesToReachGoal(results.getInt("minutes_to_reach_goal"));
		goal.setComplete(results.getBoolean("is_complete"));
		return goal;
	}

	@Override
	public List<Goal> getListOfGoalsByFamily(long familyId) {
		// TODO Auto-generated method stub
		return null;
	}

}
