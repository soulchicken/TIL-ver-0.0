package code.basic;

public class App {
	public static void main(String[] args) {
		Mouse mini = new Mouse(10, "미니", "하와이", "구직중");
		Mouse mickey = new Mouse(25, "미키", "런던", "맨체스터 유나이티드");
		Mouse jay = new Mouse(15, "제이", "상하이", "텐센트");
		Mouse jerry = new Mouse(20, "제리", "도쿄", "라인");
		Mouse jamie = new Mouse(40, "제이미", "대한민국", "삼성");

		// Mouse 배열 생성 후 추가, 반복문으로 출력
		Mouse[] mice = {mini, mickey, jay, jerry, jamie};
		for (Mouse mouse : mice) {
			System.out.println(mouse);	
		}
		
		System.out.println();
		
		// jay의 정보를 수정하고 싶음.
		//거주지를 프랑스, 회사를 루브르 박물관으로 변경하고 싶음.
		jay.setAddress("프랑스");
		jay.setCompany("루브르 박물관");
		System.out.println(jay);
		
		System.out.println("jerry의 회사 : "+jerry.getCompany());

		// 쥐의 정보 삭제, jay, jamie의 정보 삭제
		mice[2] = null;
		System.out.println(mice[2]);
		mice[4] = null;
		System.out.println(mice[4]);

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		for (Mouse mouse : mice) {
			System.out.println(mouse);
		}
	}
}
