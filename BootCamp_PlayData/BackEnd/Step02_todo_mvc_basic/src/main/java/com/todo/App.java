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
		// App.java���� todo-data-simple.txt�� �б� ���ؼ���
		// �ش� ������ ��ġ ��θ� �˾ƾ���.
		final Path filePath =Paths.get(RESOURCES + "todo-data-simple.txt");
		
		// todo-data-simple.txt�� ������ �� ��ȸ
		// Long�� int�� ����ȯ
		int rows = (int) Files.lines(filePath).count();
		
		Todo[] todos = new Todo[rows];
		
		// ���� �б�
		List<String> lines =Files.readAllLines(filePath);

		int index = 0;
		for (String line : lines) {
			final String[] columns = line.split("\t");
			Long numbers = Long.parseLong(columns[0]);
			String title = columns[1];
			String description = columns[3];
			
			// ��¥ ����
			LocalDate dueDate = LocalDate.parse(columns[2]);
			todos[index] = new Todo(numbers, title, description, dueDate);
			
			// index 1�� �ø���
			index++;
		}
		
		for (Todo todo : todos) {
			System.out.println(todo);
		}
		
		
		// ���ϴ� ���� ��ȣ�� �ϳ��� Todo ��ȸ
		Long todoNumber = 2L; // ���� 2���� ����ϰ� �;�!
		for (Todo todo : todos) {
			if (todo.number == todoNumber) {
				System.out.println(todo);
			}
		}
	}
}
