package lessons.graph.kruskal;

import lessons.graph.Edge;
import lessons.graph.Graph;
import lessons.graph.Node;

import java.util.*;

/**
 * K算法，解决图的最小路径问题（利用并查集）
 *
 * @author chensy6
 * @CreateDate 2022/2/17 14:18
 **/
public class Kruskal {

    public class UnionFind {
        public Map<Node, Node> fatherMap;
        public Map<Node, Integer> sizeMap;

        public UnionFind() {
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
        }

        public void setUnionMap(Collection<Node> nodes) {
            for (Node node : nodes) {
                fatherMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        public boolean sameUnion(Node a, Node b) {
            return findFather(a) == findFather(b);
        }

        public Node findFather(Node node) {
            Stack<Node> stack = new Stack<>();
            while (node != fatherMap.get(node)) {
                stack.push(node);
                node = fatherMap.get(node);
            }
            while (!stack.isEmpty()) {
                fatherMap.put(stack.pop(), node);
            }
            return node;
        }

        public void unionSet(Node a, Node b) {
            Node parentA = fatherMap.get(a);
            Node parentB = fatherMap.get(b);
            Node large = sizeMap.get(parentA) > sizeMap.get(parentB) ? parentA : parentB;
            Node small = large == parentA ? parentB : parentA;
            sizeMap.put(large, sizeMap.get(large) + sizeMap.get(small));
            fatherMap.put(small, large);
            fatherMap.remove(small);
        }
    }

    public Set<Edge> krusal(Graph graph) {
        Set<Edge> ans = new HashSet<>();
        UnionFind unionFind = new UnionFind();
        unionFind.setUnionMap(graph.nodeMap.values());
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        for (Edge edge : graph.edges) {
            priorityQueue.add(edge);
        }

        while (!priorityQueue.isEmpty()) {
            Edge poll = priorityQueue.poll();
            if (unionFind.sameUnion(poll.from, poll.to)) {
                ans.add(poll);
                unionFind.unionSet(poll.from, poll.to);
            }
        }
        return ans;
    }

}
