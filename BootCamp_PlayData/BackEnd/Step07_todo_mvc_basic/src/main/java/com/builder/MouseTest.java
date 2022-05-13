package com.builder;

public class MouseTest {
	public static void main(String[] args) {
//		Mouse jerry = new Mouse("제리", null, "갈색", 2, 0);
//		
//		// 점층적 생성자 패턴
//		Mouse jay = new Mouse();
//		System.out.println(jay);
//		
//		Mouse jamie = new Mouse("제이미");
//		System.out.println(jamie);
//		
//		Mouse jayz = new Mouse("제이지","제이지의 주소");
//		System.out.println(jayz);
		
		// 빌더 패턴
		
		Mouse micky = new Mouse.Builder("미키")
	  	 	 				   .address("하와이")
							   .age(3)
							   .build();
		System.out.println(micky);
	}
}
