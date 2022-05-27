package dev.sample.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Major {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MAJOR_ID")
	private Long id;

	@Column(name = "MAJOR_NAME")
	private String majorName; // �÷��� : MAJOR_NAME

	// mappedBy : �ݴ���(Student)������ �ʵ� �̸��� ������ ����. Student.java�� major �ʵ�.
	@OneToMany(mappedBy = "major") // �а�(1)�� ���� �л���(N)�� �����ϰ� ����
	private List<Student> students = new ArrayList<>();

	public Major() {
	}

	public Major(String majorName) {
		this.majorName = majorName;
	}

	public Major(Long id, String majorName) {
		super();
		this.id = id;
		this.majorName = majorName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

//	@Override
//	public String toString() {
//		return "Major [id=" + id + ", majorName=" + majorName + ", students=" + students + "]";
//	}



}