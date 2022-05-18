package com.sample;

public class Student {
	// student가 갖고 있는 속성들을 "선언(정의)"
	// 멤버 변수 (멤버 필드)
	int studentID; // 학번
	String studentName; // 이름
	int grade; // 학년
	String address; // 주소
	
	
	
	// 멤버 메서드 : 학생이 할 수 있는 기능
	
	// 생성자 함수를 통한 설정
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



	// 1. 학생의 이름과 주소만 출력해주는 메시지
	// 접근제어자 반환타입 메서드명() {return (반환타입)}
	public void showStudent() {
		System.out.println(studentName + ", " + address);
	} // ShowStudent() 끝
	
	
} // Student 끝
