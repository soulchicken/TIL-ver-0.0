package com.todo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.builder.Mouse;
import com.todo.model.Todo;
import com.todo.utils.DBUtils;

// Data Access Object, DB 접근을 담당하는 클래스
public class TodoDAO {

	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;
	private Todo todo;
	
	
	public List<Todo> findAll() {
		
		// 실제 쿼리 전달 및 수행 (진행 시켜)
		// SELECT Query
		final String selectQuery = "SELECT * FROM todo";
		List<Todo> todos = new ArrayList<>();
		
		try {
			// java와 MySQL의 연결통로 (Connection) 생성
			connection = DBUtils.getConnection();
			// 통로를 통해 SQL을 전달할 객체 Statement 생성
			statement = connection.createStatement();
			
			// 실제 쿼리 전달 및 수행 (진행 시켜)
			resultSet = statement.executeQuery(selectQuery);
			
			while (resultSet.next()) {

				todo = new Todo.Builder(resultSet.getLong("id"))
						   .title(resultSet.getString("title"))
						   .dueDate(resultSet.getDate("due_date").toLocalDate())
						   .isCompleted(resultSet.getBoolean("is_completed"))
						   .build();
				
				todos.add(todo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return todos;
	}
	public Todo findById(Long id) {
		final String selectQuery = "SELECT * FROM todo WHERE id = ?";
		Todo todo = null;
		try (
				// java와 MySQL의 연결통로 (Connection) 생성
				Connection connection = DBUtils.getConnection();
				// 통로를 통해 SQL을 전달할 객체 Statement 생성
				PreparedStatement preparedStatement = createPrepaeredStatement(connection, selectQuery, id);
				// 실제 쿼리 전달 및 수행 (진행 시켜)
				ResultSet resultSet = preparedStatement.executeQuery();
			)
		{
			if (resultSet.next()) {
				todo = new Todo.Builder(resultSet.getLong("id"))
							   .title(resultSet.getString("title"))
							   .dueDate(resultSet.getDate("due_date").toLocalDate())
							   .isCompleted(resultSet.getBoolean("is_completed"))
							   .build();
		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return todo;		
	}

	private PreparedStatement createPrepaeredStatement(Connection connection, String sql, Long id) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setLong(1, id);
		return preparedStatement;
	}
	
	public int save(Todo newTodo) {
		final String insertQuery = "INSERT INTO todo (title, description, due_date) VALUES (?,?,?)";
		int affectedRows = 0;
		try (
				// java와 MySQL의 연결통로 (Connection) 생성
				Connection connection = DBUtils.getConnection();
				// 통로를 통해 SQL을 전달할 객체 Statement 생성
				PreparedStatement preparedStatement = createPrepaeredStatement(connection, insertQuery, newTodo);
				// 실제 쿼리 전달 및 수행 (진행 시켜)
			)
		{
			affectedRows = preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return affectedRows;
	}
	
	private PreparedStatement createPrepaeredStatement(Connection connection, String sql, Todo todo) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, todo.getTitle());
		preparedStatement.setString(2, todo.getDescription());
		preparedStatement.setString(3, todo.getDueDate().toString());
		return preparedStatement;
	}
	
	public boolean deleteById(Long todoNumber) {
		final String deleteQuery = "DELETE FROM todo WHERE id = ?";
		boolean result = false;
		try (
				Connection connection = DBUtils.getConnection();
				PreparedStatement preparedStatement = createPrepaeredStatement(connection, deleteQuery, todoNumber);
			)
		{
			result = preparedStatement.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean updateById(Long todoNumber, Todo todo) {
		final String updateQuery = "UPDATE todo SET title = ?, description = ?, due_date = ? WHERE id = ?";
		boolean result = false;
		try (
				Connection connection = DBUtils.getConnection();
				PreparedStatement preparedStatement = createPrepaeredStatement(connection, updateQuery, todo, todoNumber);
			)
		{
			result = preparedStatement.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private PreparedStatement createPrepaeredStatement(Connection connection, String sql, Todo todo, Long id) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, todo.getTitle());
		preparedStatement.setString(2, todo.getDescription());
		preparedStatement.setString(3, todo.getDueDate().toString());
		preparedStatement.setLong(4, todo.getNumber());
		
		return preparedStatement;
	}
}
