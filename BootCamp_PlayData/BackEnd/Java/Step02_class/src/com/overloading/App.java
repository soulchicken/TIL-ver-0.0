package com.overloading;

public class App {

	public static void main(String[] args) {
		// �� �ν��Ͻ� ����
		
		// 0. �⺻ ����
		Mouse jerry = new Mouse();
		
		// 1. ���̸� �ʱ�ȭ
		Mouse jay = new Mouse(3);
		
		// 2. �̸��� �ʱ�ȭ
		Mouse kim = new Mouse("��Ŵ");
		
		// 3. ����, �̸� �� �� ����
		Mouse park = new Mouse(2,"����");
	}

}
