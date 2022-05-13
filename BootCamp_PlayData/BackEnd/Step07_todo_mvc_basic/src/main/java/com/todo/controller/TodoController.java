package com.todo.controller;

import java.util.List;

import com.todo.model.Todo;
import com.todo.service.TodoService;
import com.todo.view.TodoView;

public class TodoController {
	// 사용자의 요청에 따라 액션을 분기'만' 해준다.

	private List<Todo> todos;
	private final TodoView todoView;
	private final TodoService todoService;
	private Exception errorObject;
	
	
	public TodoController() {
		this.todoView = new TodoView();
		this.todoService = new TodoService();
	}

	public void findAll() {		
		// 전체 결과값 조회
		todos = todoService.findAll();
		todoView.findAll(todos);
	}
	
	public void findById(Long id) {
		Todo result = todoService.findById(id);
		if (result != null) {
			todoView.findById(result);
		} else {
			// System.out.println("해당하는 Todo 데이터가 존재하지 않습니다.");
			errorObject = new Exception("해당하는 Todo 데이터가 존재하지 않습니다.");
			
			todoView.errorPage(errorObject);
			// 예외 메시지도 출력하기
			
		}
	}

	public void save(Todo newTodo) {
		int result = todoService.save(newTodo);
		// 데이터의 저장 성공여부는 todoView가 출력한다.
		if (result > 0) {
			todoView.successPage();
		} else {
			errorObject = new Exception("Database 등록 실패");
			todoView.errorPage(errorObject);
		}
	}

	public boolean deleteById(Long todoNumber) {
		boolean result = todoService.deleteById(todoNumber);
		if (result) {
			todoView.delete();
		} 
		return result;			
	}

	public boolean updateById(Long updateTodoNumber, Todo updateTodo) {
		boolean result = todoService.updateById(updateTodoNumber,updateTodo);
		if (result) {
			todoView.update();
		} 
		return result;
	}
}
