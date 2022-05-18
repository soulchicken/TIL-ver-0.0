package com.todo.service;

import java.nio.file.Path;
import java.util.List;

import com.todo.dao.TodoDAO;
import com.todo.model.Todo;

public class TodoService {
	// ����Ͻ� ������ ó���ϴ� ����
	// -> �ش� ���ø����̼ǿ��� �߿��� ������ ó���� �ϴ� ����

	// ���� �����ͺ��̽��� �����ϴ� ������ �ϴ� ������ ��Ű�� dao(Data Access Object, ������ ���� ��ü Ȥ�� Ŭ����)
	private final TodoDAO todoDAO;
	
	public TodoService() {
		todoDAO = new TodoDAO(); 
	}
	
	// ��ü ��ȸ ���
	public List<Todo> findAll() {
		// ������ ����Ͻ� ������ ����, DB�� ��ü �����͸� ������ �� �ֵ��� dao Ŭ�������� ����
		return todoDAO.findAll();
	}

	// findById : id ���� ���� ��ġ�ϴ� ������ ã��
	
	public Todo findById(Long id) {
		return todoDAO.findById(id);
	}
	
	public boolean save(String RESOURCES, Path filePath, Todo newTodo) {
		return false;
	}

	public boolean save(Todo newTodo) {
		return todoDAO.save(newTodo);
	}

	public Todo deleteById(Long todoNumber) {
		return todoDAO.deleteById(todoNumber);
	}

	public Todo updateById(Long todoNumber, Todo updateTodo) {
		return todoDAO.updateById(todoNumber,updateTodo);
	}
}
