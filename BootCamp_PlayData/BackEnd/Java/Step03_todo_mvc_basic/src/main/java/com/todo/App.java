package com.todo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import com.todo.data.TodoTSVParser;
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
		Todo[] todos  = todoTSVParser.parseLinesFromTSV(lines, rows);
		findAll(todos);
		
		System.out.println(findById(todos,1L).toString());
	}

	// 전체 Todos 조회
	static void findAll(Todo[] todos) {
		for (Todo todo : todos) {
			System.out.println(Arrays.toString(todos));
		}
	}
	// 할 일 순서 번호로 하나의 Todo 조회
	static Todo findById(Todo[] todos, Long todoNumber) {
		for (Todo todo : todos) {
			if (todo.getNumber() == todoNumber) {
				return todo;
			}
		}
		return null;
	}
}