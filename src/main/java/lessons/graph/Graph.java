package lessons.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 图
 *
 * @author chensy6
 * @CreateDate 2022/2/15 15:49
 **/
public class Graph {

    public Map<Integer, Node> nodeMap;
    public Set<Edge> edges;

    public Graph() {
        nodeMap = new HashMap<>();
        edges = new HashSet<>();
    }

}
