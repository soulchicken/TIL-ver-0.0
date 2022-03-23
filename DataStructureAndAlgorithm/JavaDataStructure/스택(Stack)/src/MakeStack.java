import java.util.ArrayList;

public class MakeStack<T> {
    public ArrayList<T> stack = new ArrayList<T>();

    public void push(T input) {
        stack.add(input);
    }

    public T pop() {
        if (stack.isEmpty()) {
            return null;
        }
        T output = stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        return output;
    }

    @Override
    public String toString() {
        return stack.toString();
    }

    public static void main(String[] args) {
        MakeStack<Integer> stack = new MakeStack<>();
        stack.push(1);
        System.out.println(stack);
        stack.push(2);
        System.out.println(stack);
        stack.push(3);
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
