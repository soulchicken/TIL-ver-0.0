package com.interfaces.polymorp;

public class App {

	public static void main(String[] args) {
		TeethShop teethShop = new TeethShop(); 
		Bitable shark = teethShop.getTeeth("ä��");
		
		shark.bite("�丶��");
		
		shark = teethShop.getTeeth("����");
		shark.bite("�Ƚɽ�����ũ");
	}

}
