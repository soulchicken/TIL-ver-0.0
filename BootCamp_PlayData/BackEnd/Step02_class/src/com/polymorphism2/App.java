package com.polymorphism2;

public class App {
	public static void main(String[] args) {
		// Animal 타입의 참조변수 animal로 Whale 타입 인스턴스 생성
		Animal animal = new Whale();
		animal.name = "Animal 타입으로 ";
		animal.sing();
		
		Whale whale = new Whale();
		whale.name = "Whale 타입으로 ";
		whale.sing();
		
//		animal.swim(); 사용 불가
		whale.swim();
		
		// 아래도 불가능
		Whale whale2 = (Whale) new Animal();
	}
}
