package com.interfaces.polymorp;

public class App {

	public static void main(String[] args) {
		TeethShop teethShop = new TeethShop(); 
		Bitable shark = teethShop.getTeeth("채식");
		
		shark.bite("토마토");
		
		shark = teethShop.getTeeth("육식");
		shark.bite("안심스테이크");
	}

}
