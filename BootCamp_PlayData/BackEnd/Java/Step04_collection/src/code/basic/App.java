package code.basic;

public class App {
	public static void main(String[] args) {
		Mouse mini = new Mouse(10, "�̴�", "�Ͽ���", "������");
		Mouse mickey = new Mouse(25, "��Ű", "����", "��ü���� ������Ƽ��");
		Mouse jay = new Mouse(15, "����", "������", "�ټ�Ʈ");
		Mouse jerry = new Mouse(20, "����", "����", "����");
		Mouse jamie = new Mouse(40, "���̹�", "���ѹα�", "�Ｚ");

		// Mouse �迭 ���� �� �߰�, �ݺ������� ���
		Mouse[] mice = {mini, mickey, jay, jerry, jamie};
		for (Mouse mouse : mice) {
			System.out.println(mouse);	
		}
		
		System.out.println();
		
		// jay�� ������ �����ϰ� ����.
		//�������� ������, ȸ�縦 ��긣 �ڹ������� �����ϰ� ����.
		jay.setAddress("������");
		jay.setCompany("��긣 �ڹ���");
		System.out.println(jay);
		
		System.out.println("jerry�� ȸ�� : "+jerry.getCompany());

		// ���� ���� ����, jay, jamie�� ���� ����
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
