package com.type_casting;

public class Primitive2 {

	public static void main(String[] args) {
		int a = 1021303333;
//		byte b = a; 불가능
		byte b = (byte) a;
		System.out.println(b); // b = 37이 나와버림
		
		int c = 127;
//		byte d = c; 불가능
		byte d = (byte) c; // 가능
		
		int f = 128;
		byte g = (byte) f;
		System.out.println(g); // -128이 출력
	}

}
