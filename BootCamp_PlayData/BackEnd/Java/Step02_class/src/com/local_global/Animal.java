package com.local_global;

public class Animal {
	int age; // instance 변수
	static String kind; // static 변수
	
	void instanceMethod() {
		
	}
	static void staticMethod() {
		Animal a = new Animal();
		System.out.println(a.age);
	}
}
