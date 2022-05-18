package com.builder;

public class Mouse {
	private String name;
	private String address;
	private String color;
	private int age;
	private int height; // 키

	@Override
	public String toString() {
		return "Mouse [name=" + name + ", address=" + address + ", color=" + color + ", age=" + age + ", height="
				+ height + "]";
	}

	
	public Mouse(Builder builder) {
		this.name = builder.name;
		this.address = builder.address;
		this.color = builder.color;
		this.age = builder.age;
		this.height = builder.height;
	}

	
	// 별도의 정적 클래스 생성
	public static class Builder {
		private String name;
		private String address;
		private String color;
		private int age;
		private int height; // 키
		
		// name이 필수로 작성해야하는 필드인 경우
		public Builder(String name) {
			this.name = name;
		}
		
		public Builder address(String address) {
			this.address = address;
			return this;
		}
		
		public Builder color(String color) {
			this.color = color;
			return this;
		}
		
		public Builder age(int age) {
			this.age = age;
			return this;
		}
		public Builder height(int height) {
			this.height = height;
			return this;
		}
		
		public Mouse build() {
			return new Mouse(this);
		}
	}
	
}
