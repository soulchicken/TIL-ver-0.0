package com.sample;

public class Student {
	// student�� ���� �ִ� �Ӽ����� "����(����)"
	// ��� ���� (��� �ʵ�)
	int studentID; // �й�
	String studentName; // �̸�
	int grade; // �г�
	String address; // �ּ�
	
	
	
	// ��� �޼��� : �л��� �� �� �ִ� ���
	
	// ������ �Լ��� ���� ����
	public Student(int studentID, String studentName, int grade, String address) {
		this.studentID = studentID;
		this.studentName = studentName;
		this.grade = grade;
		this.address = address;
	}



	public Student(int studentID, String studentName, int grade) {
		this.studentID = studentID;
		this.studentName = studentName;
		this.grade = grade;
	}



	// 1. �л��� �̸��� �ּҸ� ������ִ� �޽���
	// ���������� ��ȯŸ�� �޼����() {return (��ȯŸ��)}
	public void showStudent() {
		System.out.println(studentName + ", " + address);
	} // ShowStudent() ��
	
	
} // Student ��
