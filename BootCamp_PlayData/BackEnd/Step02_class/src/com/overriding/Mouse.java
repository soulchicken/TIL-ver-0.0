package com.overriding;

public class Mouse extends Animal {
	public String address;

	// �������̵�
	@Override
	public void showName() {
		System.out.println("�� �̸��� ����̾�");
	}

	// �����ε�
	public void showName(String yourName) {
		System.out.printf("%s �ȳ�! ���� %s��",yourName,name);
		System.out.println();
	}
	
	public void showAddress() {
		System.out.printf("%s�� %s�� ���",name, address);
	}
}
