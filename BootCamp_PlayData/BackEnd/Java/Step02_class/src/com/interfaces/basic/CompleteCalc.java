package com.interfaces.basic;

// Calc 인터페이스를 구현할 '구현 클래스(구현체)'
public class CompleteCalc implements Calc {

	@Override
	public int add(int a, int b) {
		return a+b;
	}

	@Override
	public int substract(int a, int b) {
		return a-b;
	} // Calc 인터페이스를 구현하기 위한 명시를 해야한다
	
}
