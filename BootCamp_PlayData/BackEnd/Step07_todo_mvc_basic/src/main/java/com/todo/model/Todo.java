package com.todo.model;

import java.sql.Date;
import java.time.LocalDate;

import com.builder.Mouse;
import com.builder.Mouse.Builder;

public class Todo {
	public Long number; // �� �� ��ȣ
	private String title; // �� �� ����
	private String description; // �� �� ����
	private LocalDate dueDate; // �� �� ��¥
	private Boolean isCompleted; // ���� ����
	
	public Todo(Builder builder) {
		this.number = builder.number;
		this.title = builder.title;
		this.description = builder.description;
		this.dueDate = builder.dueDate;
		this.isCompleted = builder.isCompleted;
	}
	
	public Todo(Long number, String title, String description, LocalDate dueDate, Boolean isCompleted) {
		this.number = number;
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.isCompleted = isCompleted;
	}

	public Todo(String title, String description, LocalDate todoDueDate) {
		this.title = title;
		this.description = description;
		this.dueDate = todoDueDate;
	}

	public Todo(Long number, String title, String description, LocalDate todoDueDate) {
		this.number = number;
		this.title = title;
		this.description = description;
		this.dueDate = todoDueDate;
		
		isCompleted = false;
	}

	// ������ ���� Ŭ���� ����
	public static class Builder {
		public Long number; // �� �� ��ȣ
		private String title; // �� �� ����
		private String description; // �� �� ����
		private LocalDate dueDate; // �� �� ��¥
		private Boolean isCompleted; // ���� ����
		
		// name�� �ʼ��� �ۼ��ؾ��ϴ� �ʵ��� ���
		public Builder(Long number) {
			this.number = number;
		}
		
		public Builder title(String title) {
			this.title = title;
			return this;
		}
		
		public Builder description(String description) {
			this.description = description;
			return this;
		}
		
		public Builder dueDate(LocalDate dueDate) {
			this.dueDate = dueDate;
			return this;
		}

		public Builder isCompleted(Boolean isCompleted) {
			this.isCompleted = isCompleted;
			return this;
		}
		
		public Todo build() {
			return new Todo(this);
		}
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
		return dueDate;
	}

	public void setDueDate(LocalDate todoDueDate) {
		this.dueDate = todoDueDate;
	}

	public Boolean getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public void printTodo() {
		System.out.println(number + "��° �� ���� ! " + title + " !");
		System.out.println("�� ������ '"+ description + "'(��)�� ������ " + dueDate + "�Դϴ�.");
		System.out.println();
	}
	
	// �������̵��� ����ؼ� ���� ���� ��� ����ϱ�
	@Override
	public String toString() {

		return (number + "��° �� ���� ! " + title + " !\n"
				+ "�� ������ '"+ description + "'(��)�� ������ " 
				+ dueDate + "�Դϴ�.\n\n");
	}
	
}
