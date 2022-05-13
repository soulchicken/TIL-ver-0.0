package com.overriding;

public class Mouse extends Animal {
	public String address;

	// 오버라이딩
	@Override
	public void showName() {
		System.out.println("내 이름은 비밀이야");
	}

	// 오버로딩
	public void showName(String yourName) {
		System.out.printf("%s 안녕! 나는 %s야",yourName,name);
		System.out.println();
	}
	
	public void showAddress() {
		System.out.printf("%s는 %s에 살아",name, address);
	}
}
