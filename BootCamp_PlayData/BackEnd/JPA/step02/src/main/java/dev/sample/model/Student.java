package dev.sample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student {
	@Id // PK로 맵핑 설정
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id", nullable = false)
	private Long id;
	@Column(name = "student_name", nullable = false)
	private String studentName;

	@ManyToOne // student와 major의 관계는 다대일 (N:1)
	@JoinColumn(name = "major_id")
	private Major major;
	
	
	
	public Student() {}

	public Student(Long id, String studentName) {
		this.id = id;
		this.studentName = studentName;
	}

	public Student(String studentName) {
		this.studentName = studentName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", studentName=" + studentName + ", major=" + major + "]";
	}
	
	
	
}
