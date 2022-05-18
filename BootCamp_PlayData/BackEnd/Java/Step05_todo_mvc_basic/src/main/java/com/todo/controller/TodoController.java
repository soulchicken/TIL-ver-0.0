package com.todo.controller;

import java.nio.file.Path;
import java.util.List;

import com.todo.model.Todo;
import com.todo.service.TodoService;
import com.todo.view.TodoView;

public class TodoController {
	// ������� ��û�� ���� �׼��� �б�'��' ���ش�.

	private List<Todo> todos;
	private final TodoView todoView;
	private final TodoService todoService;
	
	public TodoController(List<Todo> todos) {
		this.todos = todos;
		this.todoView = new TodoView();
		this.todoService = new TodoService();
	}



	public void findAll() {		
		// ��ü ����� ��ȸ
		todoView.findAll(todos);
	}
	
	public void findById(Long todoNumber) {
		Todo result = todoService.findById(todos, todoNumber);
		todoView.findById(result);
	}
	
	public void save(String RESOURCES, Path filePath, Todo newTodo) {
		// ���� ������ ���忡 ���� ó���� service�� �Ѵ�
		boolean result = todoService.save(RESOURCES, filePath, newTodo);
		
		// �������� ���� �������δ� todoView�� ����Ѵ�.
		if (result) {
			todoView.successPage();
		} else {
			todoView.errorPage();
		}
	}
}
