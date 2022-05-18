package com.todo.controller;

import java.nio.file.Path;
import java.util.List;

import com.todo.model.Todo;
import com.todo.service.TodoService;
import com.todo.view.TodoView;

public class TodoController {
	// 사용자의 요청에 따라 액션을 분기'만' 해준다.

	private List<Todo> todos;
	private final TodoView todoView;
	private final TodoService todoService;
	
	public TodoController(List<Todo> todos) {
		this.todos = todos;
		this.todoView = new TodoView();
		this.todoService = new TodoService();
	}



	public void findAll() {		
		// 전체 결과값 조회
		todoView.findAll(todos);
	}
	
	public void findById(Long todoNumber) {
		Todo result = todoService.findById(todos, todoNumber);
		todoView.findById(result);
	}
	
	public void save(String RESOURCES, Path filePath, Todo newTodo) {
		// 실제 데이터 저장에 대한 처리는 service가 한다
		boolean result = todoService.save(RESOURCES, filePath, newTodo);
		
		// 데이터의 저장 성공여부는 todoView가 출력한다.
		if (result) {
			todoView.successPage();
		} else {
			todoView.errorPage();
		}
	}
}
