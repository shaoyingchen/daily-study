package lessons.graph.topologySort;

import lessons.graph.Graph;
import lessons.graph.Node;

import java.util.*;

/**
 * 拓扑排序
 *
 * @author chensy6
 * @CreateDate 2022/2/16 14:34
 **/
public class Topology {

    public List<Node> sortedTopology(Graph graph) {
        List<Node> ans = new ArrayList<>();
        //存储节点入度
        Map<Node, Integer> inMap = new HashMap<>();
        //所有的入度为0的节点
        Queue<Node> zeroInNode = new LinkedList<>();
        for (Node node : graph.nodeMap.values()) {
            if (node.in == 0) {
                zeroInNode.add(node);
            }
            inMap.put(node, node.in);
        }

        while (!zeroInNode.isEmpty()) {
            Node poll = zeroInNode.poll();
            ans.add(poll);
            for (Node next : poll.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0) {
                    zeroInNode.add(next);
                }
            }
        }
        return ans;
    }

}
