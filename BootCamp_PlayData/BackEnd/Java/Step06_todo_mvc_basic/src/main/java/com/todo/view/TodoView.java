package com.todo.view;

import java.time.format.DateTimeFormatter;
import java.util.List;

import com.todo.model.Todo;

public class TodoView {
	// ���� ����� ����� ����ϴ� ����
	
	// 1. ��ü ��ȸ ��� ���
	public void findAll(List<Todo> todos) {
		System.out.println("��ü ��ȸ ��� ����Դϴ�.");
		for (Todo todo : todos) {
			System.out.println(String.format("%d ��°�� �ؾ� �� ���� %s �Դϴ�.", todo.getNumber(), todo.getTitle()));
		    System.out.println(todo.getDueDate().format(DateTimeFormatter.ofPattern("������ yyyy�� MM�� dd�� �����Դϴ�.")));
		    System.out.println();
		}
	}
	
	public void findById(Todo todo) {
		System.out.println(String.format("%d ��°�� �ؾ� �� ���� %s �Դϴ�.", todo.getNumber(), todo.getTitle()));
	    System.out.println(todo.getDueDate().format(DateTimeFormatter.ofPattern("������ yyyy�� MM�� dd�� �����Դϴ�.")));
	    System.out.println();
	}

	public void successPage() {
		System.out.println("���� ��ϵǾ����ϴ�.");
	}

	public void errorPage(Exception errorObject) {
		System.out.println("������ �߻��Ͽ����ϴ�. "+errorObject.getMessage());
	}
	
	public void errorPage() {
		System.out.println("������ �߻��Ͽ����ϴ�.");
	}

	public void delete() {
		System.out.println("���� ���� �Ǿ����ϴ�.");
	}

	public void update() {
		System.out.println("���� ���� �Ǿ����ϴ�.");
	}
	
	
}
