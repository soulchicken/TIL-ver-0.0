package com.todo.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
	
	// �� �پ� �Ľ� ��, �迭�� �߰��ϴ� �޼���
	// �Ľ��� �Ϸ�� todo �迭 ��ȯ
	
	public List<Todo> parseLinesFromTSV(List<String> lines, int numberOfRows) {
		// todos �迭���� �� �ʱ�ȭ
		List<Todo> todos = new ArrayList<Todo>();
		
		// index ���� �ʱ�ȭ
		// �ݺ��� �ۼ�
		for (String line : lines) {
			todos.add(parseFromTSV(line));
		}
		return todos;
	}
}