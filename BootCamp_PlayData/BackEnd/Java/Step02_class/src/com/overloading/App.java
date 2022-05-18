package com.overloading;

public class App {

	public static void main(String[] args) {
		// 쥐 인스턴스 생성
		
		// 0. 기본 생성
		Mouse jerry = new Mouse();
		
		// 1. 나이만 초기화
		Mouse jay = new Mouse(3);
		
		// 2. 이름만 초기화
		Mouse kim = new Mouse("쥐킴");
		
		// 3. 나이, 이름 둘 다 지정
		Mouse park = new Mouse(2,"쥐팍");
	}

}
