package com.interfaces.advanced;

public class App {

	public static void main(String[] args) {
		// 음악을 재생해야하기 때문에 Audio 인스턴스 lpRecord 생성
		Audio lpRecord = new Audio();
		// lpRecord 가 musicPlay(재생할 앨범)을 호출
		Playable lp = new Park();
		lpRecord.musicPlayer(lp);
		// 넣은 앨범의 음악이 재생됨.
	}

}
