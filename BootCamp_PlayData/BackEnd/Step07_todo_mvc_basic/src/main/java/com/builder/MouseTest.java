package com.builder;

public class MouseTest {
	public static void main(String[] args) {
//		Mouse jerry = new Mouse("����", null, "����", 2, 0);
//		
//		// ������ ������ ����
//		Mouse jay = new Mouse();
//		System.out.println(jay);
//		
//		Mouse jamie = new Mouse("���̹�");
//		System.out.println(jamie);
//		
//		Mouse jayz = new Mouse("������","�������� �ּ�");
//		System.out.println(jayz);
		
		// ���� ����
		
		Mouse micky = new Mouse.Builder("��Ű")
	  	 	 				   .address("�Ͽ���")
							   .age(3)
							   .build();
		System.out.println(micky);
	}
}
