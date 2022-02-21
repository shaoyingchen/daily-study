package lessons.graph;

/**
 * 生成图
 *
 * @author chensy6
 * @CreateDate 2022/2/15 15:57
 **/
public class GraphGener {

    public Graph generGraph(int[][] matrix) {
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            int weight = matrix[i][0];
            int from = matrix[i][1];
            int to = matrix[i][2];
            if (!graph.nodeMap.containsKey(from)) {
                Node node = new Node(from);
                graph.nodeMap.put(from, node);
            }
            if (!graph.nodeMap.containsKey(to)) {
                Node node = new Node(to);
                graph.nodeMap.put(to, node);
            }
            Node fromNode = graph.nodeMap.get(from);
            Node toNode = graph.nodeMap.get(to);
            Edge edge = new Edge(weight, fromNode, toNode);
            graph.edges.add(edge);
            fromNode.edges.add(edge);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
        }
        return graph;
    }

}
