package com.todo;

import java.time.LocalDate;

import com.todo.controller.TodoController;
import com.todo.model.Todo;

public class App {

	public static void main(String[] args) {

		
		
		// Controller 생성
		// - 사용자의 요청(request)에 따라 등록, 조회 등 어떤 액션을 수행할지 분기, 결정
		// 결과값 출력
		
		TodoController todoController = new TodoController();
		todoController.findAll();
		
		// 하나의 todo 조회
		System.out.println("------------------------");
		System.out.println("하나의 투두 조회해버리기!");
		Long todoNumber = 6L;
		todoController.findById(todoNumber);
		

		// 할 일을 추가하는 부분을별도의 클래스 TodoTSVWriter.java로 분리
		
		
		// 새롭게 등록할 Todo 일정(객체) 생성
		// Long number, String title, String description, LocalDate todoDueDate
		Todo newTodo = new Todo("움직이기","집 밖에 나간다", LocalDate.of(2022, 04, 05));
		todoController.save(newTodo);
//		 todo 데이터 쓰기(저장) 처리
		
		System.out.println("\n\n---------전체 투두스 조회---------------");
		todoController.findAll();
		
		
		// 데이터를 지워보기!
		Long deleteTodoNumber = 6L;
		System.out.println("정~말로 지워졌을까? 지운 투두! " + todoController.deleteById(deleteTodoNumber));
		
		System.out.println("\n\n---------하나를 지운 다음 투두스 조회---------------");
		todoController.findAll();
		
		// 데이터를 변경해보기!
		// 하나의 투두 수정 (Update)
		Long updateTodoNumber = 5L;
		Todo updateTodo = new Todo("치킨먹기","무슨 치킨이든 상관없다.", LocalDate.of(2022, 04, 05));
		System.out.println("정~말로 바뀌었을까? 바뀐 투두! " + todoController.updateById(updateTodoNumber,updateTodo));
		System.out.println("\n\n---------하나를 바꾼 다음 투두스 조회---------------");
		todoController.findAll();
	}
}