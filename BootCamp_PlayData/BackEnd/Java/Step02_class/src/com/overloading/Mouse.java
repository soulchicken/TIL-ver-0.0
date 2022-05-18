package com.overloading;

public class Mouse {
	private int age;
	private String name;
	
	// »ı¼ºÀÚ
	public Mouse() {}
	
	public Mouse(int age) {
		this.age = age;
	}
	
	public Mouse(String name) {
		this.name = name;
	}
	
	public Mouse(int age, String name) {
		this.age = age;
		this.name = name;
	}	
}
