package dev.sample;

import dev.sample.model.Major;
import dev.sample.model.Student;

public class App {
	public static void main(String[] args) {
		Student student1 = new Student(1L, "Kim");
		Student student2 = new Student(2L, "Dong");
		
//		Major major = new Major(1L,"컴퓨터 공학");
//		
//		student1.setMajor(major);
//		
		Major foundMajor = student1.getMajor();
		System.out.println(foundMajor);
	}
}
