package com.todo.controller;

import java.util.List;

import com.todo.model.Todo;
import com.todo.service.TodoService;
import com.todo.view.TodoView;

public class TodoController {
	// ������� ��û�� ���� �׼��� �б�'��' ���ش�.

	private List<Todo> todos;
	private final TodoView todoView;
	private final TodoService todoService;
	private Exception errorObject;
	
	
	public TodoController() {
		this.todoView = new TodoView();
		this.todoService = new TodoService();
	}

	public void findAll() {		
		// ��ü ����� ��ȸ
		todos = todoService.findAll();
		todoView.findAll(todos);
	}
	
	public void findById(Long id) {
		Todo result = todoService.findById(id);
		if (result != null) {
			todoView.findById(result);
		} else {
			// System.out.println("�ش��ϴ� Todo �����Ͱ� �������� �ʽ��ϴ�.");
			errorObject = new Exception("�ش��ϴ� Todo �����Ͱ� �������� �ʽ��ϴ�.");
			
			todoView.errorPage(errorObject);
			// ���� �޽����� ����ϱ�
			
		}
	}

	public void save(Todo newTodo) {
		boolean result = todoService.save(newTodo);
		// �������� ���� �������δ� todoView�� ����Ѵ�.
		if (result) {
			todoView.successPage();
		} else {
			errorObject = new Exception("Database ��� ����");
			todoView.errorPage(errorObject);
		}
	}

	public Todo deleteById(Long todoNumber) {
		Todo result = todoService.deleteById(todoNumber);
		if (result != null) {
			todoView.delete();
		} 
		return result;			
	}

	public Todo updateById(Long updateTodoNumber, Todo updateTodo) {
		Todo result = todoService.updateById(updateTodoNumber,updateTodo);
		if (result != null) {
			todoView.update();
		} 
		return result;
	}
}
