package com.todo.service;

import java.util.List;

import com.todo.dao.TodoDAO;
import com.todo.model.Todo;

public class TodoService {
	
	private final TodoDAO todoDAO;
	
	public TodoService() {
		todoDAO = new TodoDAO();
	}
	
	// 1. 전체 조회 기능 findAll()
	public List<Todo> findAll() {
		return todoDAO.findAll();
	}
	
	// 2. 조회기능2, 할 일 순서 번호로 하나의 Todo 조회 메서드
	public Todo findById(Long id) {
		return todoDAO.findById(id);
	}

	public int save(Todo newTodo) {
		return todoDAO.save(newTodo);
	}

	public boolean updateById(Long todoNumber, Todo todo) {
		return todoDAO.updateById(todoNumber,todo);
	}

	public boolean deleteById(Long todoNumber) {
		return todoDAO.deleteById(todoNumber);
	}
}
