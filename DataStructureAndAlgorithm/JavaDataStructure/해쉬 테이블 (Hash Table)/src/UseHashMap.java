import java.util.HashMap;

public class UseHashMap {
    public static void main(String[] args) {
        HashMap<Integer, String> hash = new HashMap<>();
        hash.put(1,"김김김");
        hash.put(2,"나나나");
        hash.put(3,"박박박");
        hash.put(4,"이이이");

        System.out.println(hash.get(2));
    }
}
