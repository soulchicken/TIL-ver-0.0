package com.extend;

// 'extends 클래스명' 으로 확장.
// A extens B : class A는 class B의 특성을 재사용 + 확장
public class Mouse extends Animal {
	// Mouse is an Animal 성립.
	// Animal 클래스가 가진 특성을 물려받을 수 있다.
	// + 자신만의 특성을 확장할 수도 있다.
	// 특성 : 필드와 메서드
	
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
//		// age, color 필드는 상위 클래스인 Animal이 갖고 있음.
//		// 해당 필드의 초기화에는 해당 클래스에게 맡긴다.
		super(age, color);
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	// Animal.sing을 재 정의하기. (자신만의 특성에맞게)
	// 이런 것을 Overrideing이라고 한다.
	@Override // 동작이나 기능을 갖진 않고 오버라이드 됐다는 표기(라벨링).
	public void sing() {
		System.out.println("찍");
	}
	
	
}
