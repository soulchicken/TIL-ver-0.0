package com.type_casting;

public class Primitive2 {

	public static void main(String[] args) {
		int a = 1021303333;
//		byte b = a; �Ұ���
		byte b = (byte) a;
		System.out.println(b); // b = 37�� ���͹���
		
		int c = 127;
//		byte d = c; �Ұ���
		byte d = (byte) c; // ����
		
		int f = 128;
		byte g = (byte) f;
		System.out.println(g); // -128�� ���
	}

}
