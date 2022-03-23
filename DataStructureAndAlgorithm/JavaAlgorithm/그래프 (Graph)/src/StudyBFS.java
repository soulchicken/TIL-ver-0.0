import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class StudyBFS {

    public static void main(String[] args) {
        BFS bObj = new BFS();

        HashMap<String, ArrayList<String>> graph = new HashMap<String,ArrayList<String>>();
        graph.put("A",new ArrayList<>(Arrays.asList("B","C")));
        graph.put("B",new ArrayList<>(Arrays.asList("A","D")));
        graph.put("C",new ArrayList<>(Arrays.asList("A","D","H","I")));
        graph.put("D",new ArrayList<>(Arrays.asList("B","E","F")));
        graph.put("E",new ArrayList<>(Arrays.asList("D")));
        graph.put("F",new ArrayList<>(Arrays.asList("D")));
        graph.put("G",new ArrayList<>(Arrays.asList("C")));
        graph.put("H",new ArrayList<>(Arrays.asList("C")));
        graph.put("I",new ArrayList<>(Arrays.asList("C","J")));
        graph.put("J",new ArrayList<>(Arrays.asList("I")));
        System.out.println(graph);

        ArrayList<String> arr =  bObj.bfsFunc(graph,"A");
        System.out.println(arr);



    }
}
