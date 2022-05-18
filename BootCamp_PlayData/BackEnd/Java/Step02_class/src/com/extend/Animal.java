package com.extend;

public class Animal {
	private int age;
	private String color;
	
	public Animal(int age, String color) {
		this.age = age;
		this.color = color;
	}
	
	public Animal() {}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void sing() {
		System.out.println("YEAH!");
	}
}
