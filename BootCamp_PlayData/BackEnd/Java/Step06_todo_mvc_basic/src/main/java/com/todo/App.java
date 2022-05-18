package com.todo;

import java.time.LocalDate;

import com.todo.controller.TodoController;
import com.todo.model.Todo;

public class App {

	public static void main(String[] args) {

		
		
		// Controller ����
		// - ������� ��û(request)�� ���� ���, ��ȸ �� � �׼��� �������� �б�, ����
		// ����� ���
		
		TodoController todoController = new TodoController();
		todoController.findAll();
		
		// �ϳ��� todo ��ȸ
		System.out.println("------------------------");
		System.out.println("�ϳ��� ���� ��ȸ�ع�����!");
		Long todoNumber = 6L;
		todoController.findById(todoNumber);
		

		// �� ���� �߰��ϴ� �κ��������� Ŭ���� TodoTSVWriter.java�� �и�
		
		
		// ���Ӱ� ����� Todo ����(��ü) ����
		// Long number, String title, String description, LocalDate todoDueDate
		Todo newTodo = new Todo("�����̱�","�� �ۿ� ������", LocalDate.of(2022, 04, 05));
		todoController.save(newTodo);
//		 todo ������ ����(����) ó��
		
		System.out.println("\n\n---------��ü ���ν� ��ȸ---------------");
		todoController.findAll();
		
		
		// �����͸� ��������!
		Long deleteTodoNumber = 6L;
		System.out.println("��~���� ����������? ���� ����! " + todoController.deleteById(deleteTodoNumber));
		
		System.out.println("\n\n---------�ϳ��� ���� ���� ���ν� ��ȸ---------------");
		todoController.findAll();
		
		// �����͸� �����غ���!
		// �ϳ��� ���� ���� (Update)
		Long updateTodoNumber = 5L;
		Todo updateTodo = new Todo("ġŲ�Ա�","���� ġŲ�̵� �������.", LocalDate.of(2022, 04, 05));
		System.out.println("��~���� �ٲ������? �ٲ� ����! " + todoController.updateById(updateTodoNumber,updateTodo));
		System.out.println("\n\n---------�ϳ��� �ٲ� ���� ���ν� ��ȸ---------------");
		todoController.findAll();
	}
}