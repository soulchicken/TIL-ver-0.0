package com.tutorial;

public class SetterTest {

	public static void main(String[] args) {
		// 학생 인스턴스에 속성(필드)를 설정하기
		Person park = new Person();
		park.setAge(5);
		park.setName("박군");
		System.out.println(park.showPerson());
	}
}
