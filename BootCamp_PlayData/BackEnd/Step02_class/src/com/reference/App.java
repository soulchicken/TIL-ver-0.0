package com.reference;

public class App {

	public static void main(String[] args) {
		Student park = new Student("�ڼ���",25);
		Student han = new Student("�Ѽ���",20);
		System.out.println(park.getAge() + "�� " + park.getName());
		System.out.println(han.getAge() + "�� " + han.getName());
		
		park = han;
		System.out.println(park.getName()); // �Ѽ��� ��� ��.
	}
}
