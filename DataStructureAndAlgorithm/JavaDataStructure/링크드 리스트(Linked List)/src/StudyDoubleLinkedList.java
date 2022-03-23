public class StudyDoubleLinkedList {
    public static void main(String[] args) {

        DoubleLinkedList<Integer> MyLinkedList = new DoubleLinkedList<>();

        MyLinkedList.addNode(1);
        MyLinkedList.addNode(2);
        MyLinkedList.addNode(3);
        MyLinkedList.addNode(4);
        MyLinkedList.addNode(5);
        MyLinkedList.addNode(6);
        MyLinkedList.printAll();
        System.out.println("--------------------------");
        System.out.println(MyLinkedList.searchFromHead(1));
        System.out.println(MyLinkedList.searchFromTail(1));
        System.out.println(MyLinkedList.searchFromHead(7));
        System.out.println(MyLinkedList.searchFromTail(7));
        System.out.println("--------------------------");
        MyLinkedList.insertToFront(3,10); // 3 앞에 10 추가
        MyLinkedList.insertToFront(1,9); // 1 앞에 9 추가
        MyLinkedList.printAll();
        System.out.println("--------------------------");

    }
}
