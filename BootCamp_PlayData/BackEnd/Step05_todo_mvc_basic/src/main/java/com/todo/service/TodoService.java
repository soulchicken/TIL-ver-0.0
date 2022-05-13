package com.todo.service;

import java.nio.file.Path;
import java.util.List;

import com.todo.data.TodoTSVWriter;
import com.todo.model.Todo;

public class TodoService {
	// 비즈니스 로직을 처리하는 역할
	// -> 해당 어플리케이션에서 중요한 로직을 처리를 하는 역할
	
	// findById : id 값에 의해 일치하는 데이터 찾기
	
	public Todo findById(List<Todo> todos, Long todoNumber) {
		for (Todo todo : todos) {
			if (todo.getNumber() == todoNumber) {			
				return todo;
			}
		}
		return null;
	}
	
	public boolean save(String RESOURCES, Path filePath, Todo newTodo) {
		// TodoTSVWriter 인스턴스 생성
		TodoTSVWriter todoTSVWriter = new TodoTSVWriter();
		boolean result = todoTSVWriter.save(RESOURCES, filePath, newTodo);
		return result;
	}
}
