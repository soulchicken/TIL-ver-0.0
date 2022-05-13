package com.local_global;

public class App {

	public static void main(String[] args) {
		Mouse.staticTest();
		
		Mouse jerry = new Mouse();
		jerry.staticTest();
		Mouse micky = new Mouse();
		jerry.countOfValue = 2;
		System.out.println(micky.countOfValue);
	}
	public void how() {
		// 다른 메서드에서도 접근 가능
		System.out.println(Mouse.countOfValue);
	}
	
	public int add(int a, int b) {
		System.out.println("a,b");
		return a+b;
	}
	
//	public int add(int x, int y) {
//		System.out.println("x,y");
//		return x+y;
//	}
	// add(int, int) is already defined.
}
