package com.todo.service;

import java.nio.file.Path;
import java.util.List;

import com.todo.dao.TodoDAO;
import com.todo.model.Todo;

public class TodoService {
	// 비즈니스 로직을 처리하는 역할
	// -> 해당 어플리케이션에서 중요한 로직을 처리를 하는 역할

	// 실제 데이터베이스에 접근하는 역할을 하는 별도의 패키지 dao(Data Access Object, 데이터 접근 객체 혹은 클래스)
	private final TodoDAO todoDAO;
	
	public TodoService() {
		todoDAO = new TodoDAO(); 
	}
	
	// 전체 조회 기능
	public List<Todo> findAll() {
		// 별도의 비즈니스 로직은 없고, DB에 전체 데이터만 가져올 수 있도록 dao 클래스한테 위임
		return todoDAO.findAll();
	}

	// findById : id 값에 의해 일치하는 데이터 찾기
	
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
