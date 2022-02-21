package lessons.unionset;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 并查集
 *
 * @author chensy6
 * @CreateDate 2022/1/25 09:37
 **/
public class UnionSet<V> {

    public class Node<V> {
        public V value;

        public Node(V v) {
            this.value = v;
        }
    }

    public Map<V, Node<V>> nodes;
    public Map<Node<V>, Node<V>> parents;
    public Map<Node<V>, Integer> sizes;

    public UnionSet(List<V> sets) {
        nodes = new HashMap<>();
        parents = new HashMap<>();
        sizes = new HashMap<>();
        for (V v : sets) {
            Node node = new Node(v);
            nodes.put(v, node);
            parents.put(node, node);
            sizes.put(node, 1);
        }
    }

    public boolean sameSet(V a, V b) {
        if (!nodes.containsKey(a) || !nodes.containsKey(b)) return false;
        return findFather(nodes.get(a)) == findFather(nodes.get(b));
    }

    public void unionSet(V a, V b) {
        if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
            return;
        }
        Node parentA = parents.get(nodes.get(a));
        Node parentB = parents.get(nodes.get(b));
        if (parentA != parentB) {
            Node large = sizes.get(parentA) > sizes.get(parentB) ? parentA : parentB;
            Node small = large == parentA ? parentB : parentA;
            parents.put(small, large);
            sizes.put(large, sizes.get(large) + sizes.get(small));
            sizes.remove(small);
        }
    }

    public Node findFather(Node node) {
        Stack<Node> stack = new Stack<>();
        //收集沿途节点，用于后续重置
        while (node != parents.get(node)) {
            stack.push(node);
            node = parents.get(node);
        }
        //重置父节点
        while (!stack.isEmpty()) {
            parents.put(stack.pop(), node);
        }
        return node;
    }

}
