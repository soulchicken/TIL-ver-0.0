// 꼭 import 해야하는 2가지
import java.util.LinkedList;
import java.util.Queue;

public class StudyQueue {
    public static void main(String[] args) {
        // 큐 선언하기
        Queue<Integer> queue_int = new LinkedList<Integer>();
        Queue<String> queue_str = new LinkedList<String>();

        // 데이터 추가 (add 또는 offer) : 리턴 값으로 true가 나오는 것을 확인 가능
        boolean add = queue_int.add(1);
        boolean off = queue_int.offer(1);
        System.out.println(add);
        System.out.println(off);

        System.out.println(queue_int);

        int poll = queue_int.poll();
        System.out.println(poll);
        int remove = queue_int.remove();
        System.out.println(remove);
        System.out.println(queue_int);
    }

}
