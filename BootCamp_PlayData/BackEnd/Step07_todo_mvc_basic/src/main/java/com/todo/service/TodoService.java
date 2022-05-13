package com.todo.service;

import java.util.List;

import com.todo.dao.TodoDAO;
import com.todo.model.Todo;

public class TodoService {
	
	private final TodoDAO todoDAO;
	
	public TodoService() {
		todoDAO = new TodoDAO();
	}
	
	// 1. ��ü ��ȸ ��� findAll()
	public List<Todo> findAll() {
		return todoDAO.findAll();
	}
	
	// 2. ��ȸ���2, �� �� ���� ��ȣ�� �ϳ��� Todo ��ȸ �޼���
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
