package com;

public class MethodEx1 {
	public static void main(String[] args) {
		try {
			method1();			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	static void method1() throws Exception {
		method2();
		System.out.println("mothod1() ȣ��");
	}
	
	static void method2() throws Exception {
		throw new Exception("���ܸ� ���Ƿ� �߻���Ŵ");
	}
}
