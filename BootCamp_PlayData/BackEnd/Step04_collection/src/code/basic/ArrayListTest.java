package code.basic;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		Mouse mini = new Mouse(10, "�̴�", "�Ͽ���", "������");
		Mouse mickey = new Mouse(25, "��Ű", "����", "��ü���� ������Ƽ��");
		Mouse jay = new Mouse(15, "����", "������", "�ټ�Ʈ");
		Mouse jerry = new Mouse(20, "����", "����", "����");
		Mouse jamie = new Mouse(40, "���̹�", "���ѹα�", "�Ｚ");
		
		// �ߺ��� ���, ������ ����
		ArrayList<Mouse> list = new ArrayList<Mouse>();
		System.out.println(list.size());
		list.add(mini);
		System.out.println(list.size());
		list.add(mickey);
		list.add(jay);
		list.add(jerry);
		list.add(jamie);
		System.out.println(list.size());
		
		
		// 1��° ��� ���
		System.out.println(list.get(0));
		
		// 3��° ��� ����
		list.remove(3);
		System.out.println(list);
		System.out.println();
		for (Object object : list) {
			System.out.println((Mouse) object);
		}
	}

}
