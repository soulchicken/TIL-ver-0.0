package com.todo;

import java.time.LocalDate;

import com.todo.controller.TodoController;
import com.todo.model.Mouse;
import com.todo.model.Todo;
import com.todo.utils.DBUtils;

public class App {
	
	public static void main(String[] args) {
//		DBUtils.dropAndCreateTable();
		Mouse m = new Mouse();
		m.setName("hi!");
		TodoController todoController = new TodoController();
		
		// ��ü Todo ��ȸ (SELECT * FROM todo;)
		todoController.findAll();
		
		// �� �� ���� ��ȣ(id)�� �ϳ��� Todo ��ȸ
		long todoNumber = 2L; // 2�� id ��ȸ�ϱ�
		todoController.findById(todoNumber);
		Todo todo = new Todo.Builder(6L)
						    .title("���Ա�")
						    .description("������ �Ա�")
						    .dueDate(LocalDate.of(2022, 05, 22))
						    .build();
		todoController.save(todo);
		System.out.println("\n\n---------���̺� Ȯ��");
		todoController.findAll();
		System.out.println("\n\n---------����Ʈ Ȯ��");
		todoController.deleteById(14L);
		todoController.findAll();
		System.out.println("\n\n---------������Ʈ Ȯ��");
		Todo updateTodo = new Todo.Builder(5L)
			    .title("���Ա� ������Ʈ")
			    .description("������ ���̸��� �Ա�")
			    .dueDate(LocalDate.of(2022, 05, 22))
			    .build();
		todoController.updateById(5L, updateTodo);
		todoController.findAll();
	}
}