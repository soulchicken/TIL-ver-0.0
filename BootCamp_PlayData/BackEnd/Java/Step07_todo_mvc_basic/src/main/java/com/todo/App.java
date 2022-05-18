package com.todo;

import java.time.LocalDate;

import com.todo.controller.TodoController;
import com.todo.model.Mouse;
import com.todo.model.Todo;
import com.todo.utils.DBUtils;

public class App {
	
	public static void main(String[] args) {
//		DBUtils.dropAndCreateTable();
		Mouse m = new Mouse();
		m.setName("hi!");
		TodoController todoController = new TodoController();
		
		// 전체 Todo 조회 (SELECT * FROM todo;)
		todoController.findAll();
		
		// 할 일 순서 번호(id)로 하나의 Todo 조회
		long todoNumber = 2L; // 2번 id 조회하기
		todoController.findById(todoNumber);
		Todo todo = new Todo.Builder(6L)
						    .title("빵먹기")
						    .description("오지게 먹기")
						    .dueDate(LocalDate.of(2022, 05, 22))
						    .build();
		todoController.save(todo);
		System.out.println("\n\n---------세이브 확인");
		todoController.findAll();
		System.out.println("\n\n---------딜리트 확인");
		todoController.deleteById(14L);
		todoController.findAll();
		System.out.println("\n\n---------업데이트 확인");
		Todo updateTodo = new Todo.Builder(5L)
			    .title("빵먹기 업데이트")
			    .description("오지게 많이많이 먹기")
			    .dueDate(LocalDate.of(2022, 05, 22))
			    .build();
		todoController.updateById(5L, updateTodo);
		todoController.findAll();
	}
}