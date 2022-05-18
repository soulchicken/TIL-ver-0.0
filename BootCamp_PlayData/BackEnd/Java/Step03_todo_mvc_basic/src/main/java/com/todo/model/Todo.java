package com.todo.model;

import java.time.LocalDate;

public class Todo {
	public Long number; // �� �� ��ȣ
	private String title; // �� �� ����
	private String description; // �� �� ����
	private LocalDate todoDueDate; // �� �� ��¥
	private Boolean isCompleted; // ���� ����
	
	public Todo(Long number, String title, String description, LocalDate todoDueDate) {
		this.number = number;
		this.title = title;
		this.description = description;
		this.todoDueDate = todoDueDate;
		
		isCompleted = false;
	}
	
	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTodoDueDate() {
		return todoDueDate;
	}

	public void setTodoDueDate(LocalDate todoDueDate) {
		this.todoDueDate = todoDueDate;
	}

	public Boolean getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public void printTodo() {
		System.out.println(number + "��° �� ���� ! " + title + " !");
		System.out.println("�� ������ '"+ description + "'(��)�� ������ " + todoDueDate + "�Դϴ�.");
		System.out.println();
	}
	
	// �������̵��� ����ؼ� ���� ���� ��� ����ϱ�
	@Override
	public String toString() {

		return (number + "��° �� ���� ! " + title + " !\n"
				+ "�� ������ '"+ description + "'(��)�� ������ " 
				+ todoDueDate + "�Դϴ�.\n\n");
	}
	
}
