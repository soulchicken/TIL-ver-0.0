package com.overriding;

public class App {

	public static void main(String[] args) {
		Animal someAnimal = new Animal();
		someAnimal.name = "어떤 동물";
//		someAnimal.showName();
//		System.out.println();
		
		Mouse jerry = new Mouse();
		jerry.name = "제리";
		jerry.address = "하와이";
		
//		jerry.showName(); // 내 이름은 비밀이야
//		jerry.showName("톰");
		
		// 다형성 (Polymorphism)
		Animal anAnimal = new Animal();
		Mouse jay = new Mouse();
		
		// 하위클래스인 Mouse 인스턴스를
		// 상위 클래스인 Animal 타입의 참조변수에 대입
		Animal mickey = new Mouse(); // 하위 타입에서 상위 타입으로 형변환은 자동
//		mickey.address = "롯데타워"; // 상위타입으로 형변환했기 때문에 address가 없음
		
		mickey.showName(); // "내 이름은 비밀이야"(Mouse의 showName()) 가 출력...?
//		mickey.showAddress();
	
	}

}
