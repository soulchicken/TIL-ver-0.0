package com;

public class Ex5 {

	public static void main(String[] args) {
		try {
			int i = 10;
			int total = 100000000;
			while (true) {
				total /= i--;
				System.out.println(total);
			}
		} catch (Exception e) {
			System.out.println("0Àº ¸ø³ª´²~");
		}
	}

}
