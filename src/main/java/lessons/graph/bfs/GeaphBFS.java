package lessons.graph.bfs;

import lessons.graph.Node;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 图的广度优先遍历
 *
 * @author chensy6
 * @CreateDate 2022/2/15 16:05
 **/
public class GeaphBFS {

    public void bfs(Node node) {
        if (node == null) {
            return;
        }
        Set set = new HashSet();
        LinkedList<Node> linkedList = new LinkedList<>();
        linkedList.add(node);
        set.add(node);
        while (!linkedList.isEmpty()) {
            Node poll = linkedList.poll();
            System.out.println(poll.value);
            for (Node next : poll.nexts) {
                if (!set.contains(next)) {
                    linkedList.add(next);
                    set.add(next);
                }
            }
        }
    }

}
