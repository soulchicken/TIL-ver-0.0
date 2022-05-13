package com.interfaces.basic;

public interface Calc {
	double PI = 3.14; // public static final이 자동으로 붙는다.
	int ERROR = -9999999;
	
	public abstract int add(int a, int b);
	public abstract int substract(int a, int b);
	
}
