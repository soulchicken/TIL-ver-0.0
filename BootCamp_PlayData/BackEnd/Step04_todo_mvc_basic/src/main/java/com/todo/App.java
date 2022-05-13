package com.todo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.todo.data.TodoTSVParser;
import com.todo.data.TodoTSVWriter;
import com.todo.model.Todo;

public class App {

	// 객체 멤버 변수 RESOURCES 초기화
	private static final String RESOURCES = "src/main/resources/";

	public static void main(String[] args) throws IOException {
		// 데이터 읽어들임 (입력 read)
		final Path filePath = Paths.get(RESOURCES + "todo-data-simple.txt");
		Long numberOfRows = Files.lines(filePath).count();
		int rows = numberOfRows.intValue();
		List<String> lines = Files.readAllLines(filePath);
		
		// 데이터를 파싱하는 부분 : TodoTSVParser.java로 분리
		TodoTSVParser todoTSVParser = new TodoTSVParser();
		List<Todo> todos = todoTSVParser.parseLinesFromTSV(lines, rows);
		findAll(todos);
		
		System.out.println(findById(todos,1L).toString());

		// 할 일을추가하는 부분을별도의 클래스 TodoTSVWriter.java로 분리
		
		// TodoTSVWriter 인스턴스 생성
		TodoTSVWriter todoTSVWriter = new TodoTSVWriter();
		
		// 새롭게 등록할 Todo 일정(객체) 생성
		// Long number, String title, String description, LocalDate todoDueDate
		Todo newTodo = new Todo("산책하기","강아지와 산책한다", LocalDate.of(2022, 04, 05));
		// todo 데이터 쓰기(저장) 처리
		todoTSVWriter.save(RESOURCES, filePath, newTodo);
		// save(RESOURCES, filePath, newTodo) 기능 구현
	}

	
	
	
	
	// 전체 Todos 조회
	static void findAll(List<Todo> todos) {
		for (Todo todo : todos) {
			System.out.println("조회 시작!");
			System.out.println(todo);
		}
	}
	// 할 일 순서 번호로 하나의 Todo 조회
	static Todo findById(List<Todo> todos, Long todoNumber) {
		for (Todo todo : todos) {
			if (todo.getNumber() == todoNumber) {
				return todo;
			}
		}
		return null;
	}
}