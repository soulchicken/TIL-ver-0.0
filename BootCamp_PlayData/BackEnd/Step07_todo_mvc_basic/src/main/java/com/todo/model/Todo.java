package com.todo.model;

import java.sql.Date;
import java.time.LocalDate;

import com.builder.Mouse;
import com.builder.Mouse.Builder;

public class Todo {
	public Long number; // 할 일 번호
	private String title; // 할 일 제목
	private String description; // 할 일 내용
	private LocalDate dueDate; // 할 일 날짜
	private Boolean isCompleted; // 진행 여부
	
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

	// 별도의 정적 클래스 생성
	public static class Builder {
		public Long number; // 할 일 번호
		private String title; // 할 일 제목
		private String description; // 할 일 내용
		private LocalDate dueDate; // 할 일 날짜
		private Boolean isCompleted; // 진행 여부
		
		// name이 필수로 작성해야하는 필드인 경우
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
		System.out.println(number + "번째 할 일은 ! " + title + " !");
		System.out.println("상세 내용은 '"+ description + "'(으)로 기한은 " + dueDate + "입니다.");
		System.out.println();
	}
	
	// 오버라이딩을 사용해서 위와 같은 방식 사용하기
	@Override
	public String toString() {

		return (number + "번째 할 일은 ! " + title + " !\n"
				+ "상세 내용은 '"+ description + "'(으)로 기한은 " 
				+ dueDate + "입니다.\n\n");
	}
	
}
