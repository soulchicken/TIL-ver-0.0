package com.polymorphism2;

public class App {
	public static void main(String[] args) {
		// Animal Ÿ���� �������� animal�� Whale Ÿ�� �ν��Ͻ� ����
		Animal animal = new Whale();
		animal.name = "Animal Ÿ������ ";
		animal.sing();
		
		Whale whale = new Whale();
		whale.name = "Whale Ÿ������ ";
		whale.sing();
		
//		animal.swim(); ��� �Ұ�
		whale.swim();
		
		// �Ʒ��� �Ұ���
		Whale whale2 = (Whale) new Animal();
	}
}
