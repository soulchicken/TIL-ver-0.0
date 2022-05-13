package com;

public class Throw1 {
	public static void main(String[] args) {
		// 개발자가 예외를 고의적으로 발생(throw)시킬 수 있음
		try {
			// 예외 객체 생성
			Exception e = new Exception("고의로 발생시킨 예외");
			System.out.println(e);
			
			// 예외를 이제 떤져!
			throw e;
			
		} catch (Exception e) {
			System.out.println("예외는 이르케됨");
		}
		System.out.println("프로그램 정상 종료");
	}
}
