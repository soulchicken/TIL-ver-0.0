import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DFS {
    public ArrayList<String> dfsFunc(HashMap<String,ArrayList<String>> graph, String startNode) {
        ArrayList<String> visited = new ArrayList<>();
        ArrayList<String> needVisit = new ArrayList<>();

        needVisit.add(startNode);

        while (needVisit.size() > 0) {
            String node = needVisit.remove(needVisit.size() - 1);
            if (!visited.contains(node)) {
                visited.add(node);
                needVisit.addAll(graph.get(node));
            }
        }
        return visited;
    }

}