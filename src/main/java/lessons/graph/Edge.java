package lessons.graph;

/**
 * 边
 *
 * @author chensy6
 * @CreateDate 2022/2/15 15:48
 **/
public class Edge {

    public int weight;
    public Node from;
    public Node to;

    public Edge(int w, Node f, Node t) {
        weight = w;
        from = f;
        to = t;
    }


}
