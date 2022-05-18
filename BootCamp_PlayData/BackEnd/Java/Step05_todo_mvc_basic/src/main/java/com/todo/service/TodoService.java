package com.todo.service;

import java.nio.file.Path;
import java.util.List;

import com.todo.data.TodoTSVWriter;
import com.todo.model.Todo;

public class TodoService {
	// ����Ͻ� ������ ó���ϴ� ����
	// -> �ش� ���ø����̼ǿ��� �߿��� ������ ó���� �ϴ� ����
	
	// findById : id ���� ���� ��ġ�ϴ� ������ ã��
	
	public Todo findById(List<Todo> todos, Long todoNumber) {
		for (Todo todo : todos) {
			if (todo.getNumber() == todoNumber) {			
				return todo;
			}
		}
		return null;
	}
	
	public boolean save(String RESOURCES, Path filePath, Todo newTodo) {
		// TodoTSVWriter �ν��Ͻ� ����
		TodoTSVWriter todoTSVWriter = new TodoTSVWriter();
		boolean result = todoTSVWriter.save(RESOURCES, filePath, newTodo);
		return result;
	}
}
