package com.todo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.todo.controller.TodoController;
import com.todo.data.TodoTSVParser;
import com.todo.data.TodoTSVWriter;
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
		List<Todo> todos = todoTSVParser.parseLinesFromTSV(lines, rows);
		
		
		// Controller ����
		// - ������� ��û(request)�� ���� ���, ��ȸ �� � �׼��� �������� �б�, ����
		// ����� ���
		
		TodoController todoController = new TodoController(todos);
		todoController.findAll();
		
		// �ϳ��� todo ��ȸ
		Long todoNumber = 2L;
		todoController.findById(todoNumber);
		

		// �� ���� �߰��ϴ� �κ��������� Ŭ���� TodoTSVWriter.java�� �и�
		
		
		// ���Ӱ� ����� Todo ����(��ü) ����
		// Long number, String title, String description, LocalDate todoDueDate
		Todo newTodo = new Todo("��å�ϱ�","�������� ��å�Ѵ�", LocalDate.of(2022, 04, 05));
		// todo ������ ����(����) ó��
		todoController.save(RESOURCES, filePath, newTodo);
		// save(RESOURCES, filePath, newTodo) ��� ����
	}
}