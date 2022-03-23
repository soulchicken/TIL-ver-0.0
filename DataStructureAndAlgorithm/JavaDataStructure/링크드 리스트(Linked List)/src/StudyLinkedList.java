public class StudyLinkedList {
    public static void main(String[] args) {
        SingleLinkedList<Integer> MyLinkedList = new SingleLinkedList<>();
        MyLinkedList.addNode(1);
        System.out.println(MyLinkedList.head.data);

        MyLinkedList.addNode(2);
        System.out.println(MyLinkedList.head.next.data);

        MyLinkedList.addNode(3);
        MyLinkedList.PrintAllNode();

        // 1과 2 사이에 5를 넣어보기
        MyLinkedList.addNodeInside(5,1);
        System.out.println("1 5 2 3을 출력");
        MyLinkedList.PrintAllNode();
        // 5를 제거
        System.out.println(MyLinkedList.delNode(5));
        System.out.println("1 2 3을 출력");
        MyLinkedList.PrintAllNode();
    }
}
