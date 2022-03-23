// 스택 클래스 임포트
import java.util.Stack;

public class StudyStack {
    public static void main(String[] args) {
        Stack<Integer> stack_int = new Stack<Integer>(); // 정수형 스택 선언
        // 스택에 1, 2, 3 추가
        stack_int.push(1);
        stack_int.push(2);
        stack_int.push(3);
        System.out.println(stack_int);

        // pop 2번 해보기
        int pop1 = stack_int.pop();
        int pop2 = stack_int.pop();
        System.out.println(pop1 + "," + pop2);
    }

}

