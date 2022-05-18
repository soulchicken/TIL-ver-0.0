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

	// ��ü ��� ���� RESOURCES �ʱ�ȭ
	private static final String RESOURCES = "src/main/resources/";

	public static void main(String[] args) throws IOException {
		// ������ �о���� (�Է� read)
		final Path filePath = Paths.get(RESOURCES + "todo-data-simple.txt");
		Long numberOfRows = Files.lines(filePath).count();
		int rows = numberOfRows.intValue();
		List<String> lines = Files.readAllLines(filePath);
		
		// �����͸� �Ľ��ϴ� �κ� : TodoTSVParser.java�� �и�
		TodoTSVParser todoTSVParser = new TodoTSVParser();
		Todo[] todos  = todoTSVParser.parseLinesFromTSV(lines, rows);
		findAll(todos);
		
		System.out.println(findById(todos,1L).toString());
	}

	// ��ü Todos ��ȸ
	static void findAll(Todo[] todos) {
		for (Todo todo : todos) {
			System.out.println(Arrays.toString(todos));
		}
	}
	// �� �� ���� ��ȣ�� �ϳ��� Todo ��ȸ
	static Todo findById(Todo[] todos, Long todoNumber) {
		for (Todo todo : todos) {
			if (todo.getNumber() == todoNumber) {
				return todo;
			}
		}
		return null;
	}
}