package com.local_global;

public class Mouse {
	
	// Member (static Ű���尡 ���� ����) �Ӽ�, �޼���.
	// ��ü(�ν��Ͻ�)�� ������ ���Ŀ��� ���� ����
	int age;
	String name;
	
	// static Ű���尡 ���� �Ӽ� -> static(����) ���� or Ŭ���� ����
	// ��ü�� �����Ǳ� ������ ��� ����
	static int countOfValue = 1;
	
	// ��� ������ �ϴ� �޼���. static Ű���尡 ���� �ʾұ⿡ �ν��Ͻ� �޼���
	// ��ü�� ������ ���Ŀ��� ��� ����
	void sing() {
		System.out.println(name + "����");
	}
	static void staticTest() {
		System.out.println("�� ������ " + countOfValue +"��");
	}
}
