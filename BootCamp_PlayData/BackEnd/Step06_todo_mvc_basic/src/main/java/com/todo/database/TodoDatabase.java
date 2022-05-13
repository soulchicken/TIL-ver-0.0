package com.todo.database;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.todo.model.Todo;

// ������ �����ͺ��̽� ����
public class TodoDatabase {
	// ��� �ʵ�
	// Todo �����͸� ������ �÷��� ����
	private static List<Todo> todoDatabase = new ArrayList<>();
	
	// static block (�߰�ȣ�� ���� ��) : ���α׷��� ����� �� �� ���� ���� ��. �ʱ�ȭ �۾��� �� ���� ���� ���
	{
		System.out.println("static block ȣ��");
		todoDatabase.add(new Todo(1L, "�����ϱ�", "����, ���� ����", LocalDate.of(2022, 4, 5)));
		todoDatabase.add(new Todo(2L, "�����ϱ�", "�������� 1�ð� ���� ������ �Ѵ�.", LocalDate.of(2022, 5, 7)));
		todoDatabase.add(new Todo(3L, "�����ϱ�", "������ ��Ƽ� ��Ź�⸦ ������.", LocalDate.of(2022, 4, 4)));
		todoDatabase.add(new Todo(4L, "�ǾƳ�", "�п����� �ǾƳ븦 �����Ѵ�", LocalDate.of(2022, 4, 7)));
		todoDatabase.add(new Todo(5L, "������ ���ֱ�", "���������� ��Ḧ �ش�.", LocalDate.of(2022, 4, 7)));
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
