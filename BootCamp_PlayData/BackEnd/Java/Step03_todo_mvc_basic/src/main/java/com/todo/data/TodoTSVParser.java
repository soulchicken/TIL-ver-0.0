package com.todo.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.todo.model.Todo;

public class TodoTSVParser {
	private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	private Todo parseFromTSV(String line) {
		final String[] columns = line.split("\t");
		final Long id = Long.parseLong(columns[0]);
		final String title = columns[1];
		final LocalDate dueDate = LocalDate.parse(columns[2], DATE_PATTERN);
		final String description = columns[3];
		return new Todo(id, title, description, dueDate);
	}
	
	// 한 줄씩 파싱 후, 배열에 추가하는 메서드
	// 파싱이 완료된 todo 배열 반환
	
	public Todo[] parseLinesFromTSV(List<String> lines, int numberOfRows) {
		// todos 배열선언 및 초기화
		Todo[] todos = new Todo[numberOfRows];
		
		// index 변수 초기화
		int index = 0;
		// 반복문 작성
		for (String line : lines) {
			todos[index] = parseFromTSV(line);
			index++;
		}
		return todos;
	}
}
