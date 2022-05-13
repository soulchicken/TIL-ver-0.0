package com.abstracts.case1;

public class App {

	public static void main(String[] args) {
		Animal[] animal = new Animal[4];
	
		animal[0] = new Cat();
		animal[1] = new Mouse();
		animal[2] = new Dog();
		animal[3] = new Animal();
	
		for (Animal a : animal) {
			a.sing();
			// 具克酒侩, 嘛嘛,港港, 档克拱
		}
	}
}
