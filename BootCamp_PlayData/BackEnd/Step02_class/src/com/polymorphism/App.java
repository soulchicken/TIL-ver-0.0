package com.polymorphism;

public class App {

	public static void main(String[] args) {
//		Animal animal = new Animal();
//		Mammal mammal = new Mammal();
//		Cat cat = new Cat();
//		Whale whale = new Whale();
		
//		animal.showMe();
//		mammal.showMe();
//		cat.showMe();
//		whale.showMe();
		
		// ������ ����, ���� Ÿ���� ���������� ���� Ÿ���� �ν��Ͻ� �ʱ�ȭ ����.
		Animal animal = new Animal();
		Animal mammal = new Mammal();
		Animal whale = new Whale();
		Animal cat = new Cat();		
		
		animal.showMe();
		mammal.showMe();
		whale.showMe();
		cat.showMe();
		
		Animal[] animals = {animal, mammal, whale, cat};
		for (Animal ani : animals) {
			ani.showMe();
		}
		
	}

}
