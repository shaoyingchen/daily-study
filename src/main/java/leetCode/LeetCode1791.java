package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1791. 找出星型图的中心节点
 * <p>
 * 有一个无向的 星型 图，由 n 个编号从 1 到 n 的节点组成。星型图有一个 中心 节点，并且恰有 n - 1 条边将中心节点与其他每个节点连接起来。
 * <p>
 * 给你一个二维整数数组 edges ，其中edges[i] = [ui, vi] 表示在节点 ui 和 vi 之间存在一条边。请你找出并返回edges 所表示星型图的中心节点。
 *
 * @author chensy6
 * @CreateDate 2022/2/18 09:27
 **/
public class LeetCode1791 {

    /**
     * 输入：edges = [[1,2],[2,3],[4,2]]
     * 输出：2
     * 解释：如上图所示，节点 2 与其他每个节点都相连，所以节点 2 是中心节点。
     *
     * @param edges
     * @return
     */
    public int findCenter(int[][] edges) {
        if (edges == null || edges.length == 0) {
            return -1;
        }

        int N = edges.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int from = map.getOrDefault(edges[i][0], 0);
            int to = map.getOrDefault(edges[i][1], 0);
            map.put(edges[i][0], from + 1);
            map.put(edges[i][1], to + 1);
            if (from == N - 1) return edges[i][0];
            if (to == N - 1) return edges[i][1];
        }
        return -1;
    }

}
