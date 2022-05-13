package com.extend;

// 'extends Ŭ������' ���� Ȯ��.
// A extens B : class A�� class B�� Ư���� ���� + Ȯ��
public class Mouse extends Animal {
	// Mouse is an Animal ����.
	// Animal Ŭ������ ���� Ư���� �������� �� �ִ�.
	// + �ڽŸ��� Ư���� Ȯ���� ���� �ִ�.
	// Ư�� : �ʵ�� �޼���
	
	String address;
	
	
	public Mouse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Mouse(int age, String color) {
		super(age, color);
		// TODO Auto-generated constructor stub
	}

	public Mouse(int age, String color, String address) {
//		// age, color �ʵ�� ���� Ŭ������ Animal�� ���� ����.
//		// �ش� �ʵ��� �ʱ�ȭ���� �ش� Ŭ�������� �ñ��.
		super(age, color);
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	// Animal.sing�� �� �����ϱ�. (�ڽŸ��� Ư�����°�)
	// �̷� ���� Overrideing�̶�� �Ѵ�.
	@Override // �����̳� ����� ���� �ʰ� �������̵� �ƴٴ� ǥ��(�󺧸�).
	public void sing() {
		System.out.println("��");
	}
	
	
}
