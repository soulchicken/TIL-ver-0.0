package com.tutorial;

public class Person {
	String name;
	int age;
	
	public Person() {}
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String showPerson() {
		return (name + "의 나이는 "+ age + "살");
	}
}
