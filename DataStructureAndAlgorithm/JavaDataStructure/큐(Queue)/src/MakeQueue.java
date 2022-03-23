// 큐를 구현해보자

import java.util.ArrayList;

public class MakeQueue<T> {

    public ArrayList<T> que = new ArrayList<T>();


    public boolean append(T num) {
        que.add(num);
        return true;
    }

    public Object pop() {
        if (que.isEmpty()) {
            return null;
        }
        return que.remove(0);
    }

    @Override
    public String toString() {
        return que.toString();
    }

    public boolean isEmpty() {
        return que.isEmpty();
    }

    public static void main(String[] args) {
        MakeQueue<Integer> que = new MakeQueue<>();
        System.out.println(que.append(1));
        System.out.println(que);
        System.out.println(que.append(2));
        System.out.println(que.append(3));
        System.out.println(que.pop());
        System.out.println(que);
        System.out.println(que.isEmpty());
    }
}
