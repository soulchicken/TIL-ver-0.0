package com;

public class Throw1 {
	public static void main(String[] args) {
		// �����ڰ� ���ܸ� ���������� �߻�(throw)��ų �� ����
		try {
			// ���� ��ü ����
			Exception e = new Exception("���Ƿ� �߻���Ų ����");
			System.out.println(e);
			
			// ���ܸ� ���� ����!
			throw e;
			
		} catch (Exception e) {
			System.out.println("���ܴ� �̸��ɵ�");
		}
		System.out.println("���α׷� ���� ����");
	}
}
