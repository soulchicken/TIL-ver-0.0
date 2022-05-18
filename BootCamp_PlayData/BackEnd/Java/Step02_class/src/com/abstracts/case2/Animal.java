package com.abstracts.case2;

// 추상(abstract) 클래스
public abstract class Animal {
	abstract void sing(); // 추상 메서드
	// 몸체(body)는 없고 선언부만 있는 메서드
	// 일반적으로는 메서드는 몸체({}) 가 있어야하지만
	// abstract 키워드가 붙으면 추상 메서드가 되어 선언부만 작성.
	
	
	// 추상 클래스 내에 일반 메서드를 넣을 수 있다
	void eat() {
		
	}

}
