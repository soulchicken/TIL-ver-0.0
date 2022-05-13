package com.local_global;

public class Mouse {
	
	// Member (static 키워드가 붙지 않은) 속성, 메서드.
	// 객체(인스턴스)가 생성된 이후에만 접근 가능
	int age;
	String name;
	
	// static 키워드가 붙은 속성 -> static(정적) 변수 or 클래스 변수
	// 객체가 생성되기 전에도 사용 가능
	static int countOfValue = 1;
	
	// 우는 행위를 하는 메서드. static 키워드가 붙지 않았기에 인스턴스 메서드
	// 객체가 생성된 이후에만 사용 가능
	void sing() {
		System.out.println(name + "찍찍");
	}
	static void staticTest() {
		System.out.println("쥐 꼬리는 " + countOfValue +"개");
	}
}
