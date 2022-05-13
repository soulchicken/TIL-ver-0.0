package com.todo.dao;

import java.util.List;

import com.todo.database.TodoDatabase;
import com.todo.model.Todo;

// Data Access Object, DB 접근을 담당하는 클래스
public class TodoDAO {
	// 멤버 필드
	private final TodoDatabase todoDatabase;

	public TodoDAO() {
		this.todoDatabase = new TodoDatabase();
	}

	public List<Todo> findAll() {
		return TodoDatabase.getTodos();
	}

	public Todo findById(Long id) {
		return todoDatabase.findById(id);
	}

	public boolean save(Todo newTodo) {
		return TodoDatabase.save(newTodo);
	}

	public Todo deleteById(Long todoNumber) {
		return todoDatabase.deleteById(todoNumber);
	}

	public Todo updateById(Long todoNumber, Todo updateTodo) {
		return todoDatabase.updateById(todoNumber,updateTodo);
	}
	
	
	
}
