package com.interfaces.basic;

// Calc �������̽��� ������ '���� Ŭ����(����ü)'
public class CompleteCalc implements Calc {

	@Override
	public int add(int a, int b) {
		return a+b;
	}

	@Override
	public int substract(int a, int b) {
		return a-b;
	} // Calc �������̽��� �����ϱ� ���� ��ø� �ؾ��Ѵ�
	
}
