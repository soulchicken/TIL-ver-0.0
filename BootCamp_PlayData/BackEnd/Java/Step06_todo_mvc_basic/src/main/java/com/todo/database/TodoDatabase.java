package com.todo.database;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.todo.model.Todo;

// 가상의 데이터베이스 공간
public class TodoDatabase {
	// 멤버 필드
	// Todo 데이터를 보관할 컬렉션 변수
	private static List<Todo> todoDatabase = new ArrayList<>();
	
	// static block (중괄호로 만든 블럭) : 프로그램이 실행될 때 한 번만 수행 됨. 초기화 작업할 때 많이 쓰는 방법
	{
		System.out.println("static block 호출");
		todoDatabase.add(new Todo(1L, "숙제하기", "수학, 영어 숙제", LocalDate.of(2022, 4, 5)));
		todoDatabase.add(new Todo(2L, "조깅하기", "공원에서 1시간 동안 조깅을 한다.", LocalDate.of(2022, 5, 7)));
		todoDatabase.add(new Todo(3L, "빨래하기", "빨래를 모아서 세탁기를 돌린다.", LocalDate.of(2022, 4, 4)));
		todoDatabase.add(new Todo(4L, "피아노", "학원에서 피아노를 연습한다", LocalDate.of(2022, 4, 7)));
		todoDatabase.add(new Todo(5L, "강아지 밥주기", "강아지에게 사료를 준다.", LocalDate.of(2022, 4, 7)));
	}
	
	public static List<Todo> getTodos() {
		return todoDatabase;
	}

	public Todo findById(Long id) {
		for (Todo todo : todoDatabase) {
			if (todo.getNumber() == id) {			
				return todo;
			}
		}
		return null;
	}

	public static boolean save(Todo newTodo) {
		newTodo.setId(todoDatabase.size() + 1L);
		return todoDatabase.add(newTodo);
	}

	public Todo deleteById(Long todoNumber) {
		for (Todo todo : todoDatabase) {
			if (todo.getNumber() == todoNumber) {
				Todo result = todo;
				todoDatabase.remove(result);
				return result;
			}
		}
		return null;
	}

	public Todo updateById(Long todoNumber, Todo updateTodo) {
		for (Todo todo : todoDatabase) {
			if (todo.getNumber() == todoNumber) {
				todoDatabase.set(todo.getNumber().intValue() - 1, updateTodo);
				return todo;
			}
		}
		return null;
	}
}
