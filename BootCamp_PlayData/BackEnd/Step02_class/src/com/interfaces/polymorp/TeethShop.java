package com.interfaces.polymorp;

public class TeethShop {
	Bitable getTeeth (String food) {
		if (food == "ä��") {
			return new BluntTeeth();
		}
		return new SharpTeeth();
	}
}
