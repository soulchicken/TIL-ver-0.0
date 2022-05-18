package com.reference;

public class App {

	public static void main(String[] args) {
		Student park = new Student("¹Ú¼­ÁØ",25);
		Student han = new Student("ÇÑ¼ÒÈñ",20);
		System.out.println(park.getAge() + "»ì " + park.getName());
		System.out.println(han.getAge() + "»ì " + han.getName());
		
		park = han;
		System.out.println(park.getName()); // ÇÑ¼ÒÈñ Ãâ·Â µÊ.
	}
}
