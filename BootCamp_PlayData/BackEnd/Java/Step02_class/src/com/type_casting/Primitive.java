package com.type_casting;

public class Primitive {

	public static void main(String[] args) {
		// 자동 형변환
		
		byte a = 50;
		int b = a; // 더 작은 byte 타입에서 더 큰 int 타입으로의 형 변환은 자연스럽게 이뤄짐.
		char c = 'A';
		int d = c;
		
		int e = 100;
		float f = e;
		
		float g = 10.5F;
		double h = g;
		
//		long i = f; // float -> long은 안됨
		
		
	}

}
