package com.todo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import com.todo.model.Todo;

public class App {
	private static final String RESOURCES = "src/main/resources/";

	public static void main(String[] args) throws Exception {
		// App.java에서 todo-data-simple.txt를 읽기 위해서는
		// 해당 파일의 위치 경로를 알아야함.
		final Path filePath =Paths.get(RESOURCES + "todo-data-simple.txt");
		
		// todo-data-simple.txt의 데이터 수 조회
		// Long을 int로 형변환
		int rows = (int) Files.lines(filePath).count();
		
		Todo[] todos = new Todo[rows];
		
		// 파일 읽기
		List<String> lines =Files.readAllLines(filePath);

		int index = 0;
		for (String line : lines) {
			final String[] columns = line.split("\t");
			Long numbers = Long.parseLong(columns[0]);
			String title = columns[1];
			String description = columns[3];
			
			// 날짜 저장
			LocalDate dueDate = LocalDate.parse(columns[2]);
			todos[index] = new Todo(numbers, title, description, dueDate);
			
			// index 1개 올리기
			index++;
		}
		
		for (Todo todo : todos) {
			System.out.println(todo);
		}
		
		
		// 원하는 순서 번호로 하나의 Todo 조회
		Long todoNumber = 2L; // 나는 2번을 출력하고 싶어!
		for (Todo todo : todos) {
			if (todo.number == todoNumber) {
				System.out.println(todo);
			}
		}
	}
}
