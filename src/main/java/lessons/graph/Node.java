package lessons.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 点
 *
 * @author chensy6
 * @CreateDate 2022/2/15 15:48
 **/
public class Node {

    public int value;
    public int in;
    public int out;
    public List<Node> nexts;
    public List<Edge> edges;

    public Node(int v) {
        value = v;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }


}
