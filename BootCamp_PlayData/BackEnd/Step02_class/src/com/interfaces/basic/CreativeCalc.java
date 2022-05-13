package com.interfaces.basic;

public class CreativeCalc implements Calc {

	@Override
	public int add(int a, int b) {
		return (b + a) / 2;
	}

	@Override
	public int substract(int a, int b) {
		return b - a;
	}
	
}
