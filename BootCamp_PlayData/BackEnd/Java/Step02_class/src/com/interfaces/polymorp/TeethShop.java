package com.interfaces.polymorp;

public class TeethShop {
	Bitable getTeeth (String food) {
		if (food == "Ã¤½Ä") {
			return new BluntTeeth();
		}
		return new SharpTeeth();
	}
}
