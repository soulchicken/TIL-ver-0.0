package com.todo.model;

import java.time.LocalDate;

public class Todo {
	public Long number; // �� �� ��ȣ
	private String title; // �� �� ����
	private String description; // �� �� ����
	private LocalDate DueDate; // �� �� ��¥
	private Boolean isCompleted; // ���� ����
	

	
	public Todo(String title, String description, LocalDate todoDueDate) {
		this.title = title;
		this.description = description;
		this.DueDate = todoDueDate;
	}

	public Todo(Long number, String title, String description, LocalDate todoDueDate) {
		this.number = number;
		this.title = title;
		this.description = description;
		this.DueDate = todoDueDate;
		
		isCompleted = false;
	}


	public Long getNumber() {
		return number;
	}

	public void setId(Long number) {
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

	public LocalDate getDueDate() {
		return DueDate;
	}

	public void setDueDate(LocalDate todoDueDate) {
		this.DueDate = todoDueDate;
	}

	public Boolean getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public void printTodo() {
		System.out.println(number + "��° �� ���� ! " + title + " !");
		System.out.println("�� ������ '"+ description + "'(��)�� ������ " + DueDate + "�Դϴ�.");
		System.out.println();
	}
	
	// �������̵��� ����ؼ� ���� ���� ��� ����ϱ�
	@Override
	public String toString() {

		return (number + "��° �� ���� ! " + title + " !\n"
				+ "�� ������ '"+ description + "'(��)�� ������ " 
				+ DueDate + "�Դϴ�.\n\n");
	}
	
}
