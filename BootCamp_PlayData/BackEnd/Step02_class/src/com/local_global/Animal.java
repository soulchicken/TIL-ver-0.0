package com.local_global;

public class Animal {
	int age; // instance ����
	static String kind; // static ����
	
	void instanceMethod() {
		
	}
	static void staticMethod() {
		Animal a = new Animal();
		System.out.println(a.age);
	}
}
