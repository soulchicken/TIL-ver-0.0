package com.overriding;

public class App {

	public static void main(String[] args) {
		Animal someAnimal = new Animal();
		someAnimal.name = "� ����";
//		someAnimal.showName();
//		System.out.println();
		
		Mouse jerry = new Mouse();
		jerry.name = "����";
		jerry.address = "�Ͽ���";
		
//		jerry.showName(); // �� �̸��� ����̾�
//		jerry.showName("��");
		
		// ������ (Polymorphism)
		Animal anAnimal = new Animal();
		Mouse jay = new Mouse();
		
		// ����Ŭ������ Mouse �ν��Ͻ���
		// ���� Ŭ������ Animal Ÿ���� ���������� ����
		Animal mickey = new Mouse(); // ���� Ÿ�Կ��� ���� Ÿ������ ����ȯ�� �ڵ�
//		mickey.address = "�Ե�Ÿ��"; // ����Ÿ������ ����ȯ�߱� ������ address�� ����
		
		mickey.showName(); // "�� �̸��� ����̾�"(Mouse�� showName()) �� ���...?
//		mickey.showAddress();
	
	}

}
