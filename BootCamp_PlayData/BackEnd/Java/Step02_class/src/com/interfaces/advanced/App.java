package com.interfaces.advanced;

public class App {

	public static void main(String[] args) {
		// ������ ����ؾ��ϱ� ������ Audio �ν��Ͻ� lpRecord ����
		Audio lpRecord = new Audio();
		// lpRecord �� musicPlay(����� �ٹ�)�� ȣ��
		Playable lp = new Park();
		lpRecord.musicPlayer(lp);
		// ���� �ٹ��� ������ �����.
	}

}
