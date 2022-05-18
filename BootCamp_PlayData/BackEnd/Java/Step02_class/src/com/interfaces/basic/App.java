package com.interfaces.basic;

public class App {

	public static void main(String[] args) {
		// ������ ���� ��� ���
		Calc calculator = new CompleteCalc();
		System.out.println(calculator.add(3,5));
		System.out.println(calculator.substract(3,5));
		System.out.println(calculator.PI);
		
		Calc newCalc = new CreativeCalc();
		System.out.println(newCalc.add(3, 5));
		System.out.println(newCalc.substract(3, 5));
	}

}
