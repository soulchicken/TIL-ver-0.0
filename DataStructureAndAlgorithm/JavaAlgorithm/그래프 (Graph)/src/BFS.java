import java.util.ArrayList;
import java.util.HashMap;

public class BFS {
    public ArrayList<String> bfsFunc(HashMap<String,ArrayList<String>> graph, String startNode) {
        ArrayList<String> visited = new ArrayList<>();
        ArrayList<String> needVisit = new ArrayList<>();

        needVisit.add(startNode);
        while (needVisit.size() > 0) {
            String node = needVisit.remove(0);

            if (!visited.contains(node)) {
                visited.add(node);
                needVisit.addAll(graph.get(node));
            }
        }
        return visited;
    }
}
