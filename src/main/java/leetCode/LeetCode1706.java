package leetCode;

/**
 * 1706. 球会落何处
 * <p>
 * 用一个大小为 m x n 的二维网格 grid 表示一个箱子。你有 n 颗球。箱子的顶部和底部都是开着的。
 * <p>
 * 箱子中的每个单元格都有一个对角线挡板，跨过单元格的两个角，可以将球导向左侧或者右侧。
 * <p>
 * 将球导向右侧的挡板跨过左上角和右下角，在网格中用 1 表示。
 * 将球导向左侧的挡板跨过右上角和左下角，在网格中用 -1 表示。
 * 在箱子每一列的顶端各放一颗球。每颗球都可能卡在箱子里或从底部掉出来。如果球恰好卡在两块挡板之间的 "V" 形图案，或者被一块挡导向到箱子的任意一侧边上，就会卡住。
 * <p>
 * 返回一个大小为 n 的数组 answer ，其中 answer[i] 是球放在顶部的第 i 列后从底部掉出来的那一列对应的下标，如果球卡在盒子里，则返回 -1 。
 *
 * @author chensy6
 * @CreateDate 2022/2/24 09:21
 **/
public class LeetCode1706 {

    /**
     * 输入：grid = [[1,1,1,-1,-1],[1,1,1,-1,-1],[-1,-1,-1,1,1],[1,1,1,1,-1],[-1,-1,-1,-1,-1]]
     * 输出：[1,-1,-1,-1,-1]
     * 解释：示例如图：
     * b0 球开始放在第 0 列上，最终从箱子底部第 1 列掉出。
     * b1 球开始放在第 1 列上，会卡在第 2、3 列和第 1 行之间的 "V" 形里。
     * b2 球开始放在第 2 列上，会卡在第 2、3 列和第 0 行之间的 "V" 形里。
     * b3 球开始放在第 3 列上，会卡在第 2、3 列和第 0 行之间的 "V" 形里。
     * b4 球开始放在第 4 列上，会卡在第 2、3 列和第 1 行之间的 "V" 形里。
     *
     * @param grid
     * @return
     */
    public static int N;
    public static int M;

    public static int[] findBall(int[][] grid) {
        N = grid.length;
        M = grid[0].length;
        int[] ans = new int[M];
        for (int i = 0; i < M; i++) {
            ans[i] = process(grid, 0, i);
        }
        return ans;
    }

    public static int process(int[][] grid, int row, int col) {
        if (col == M - 1 && grid[row][col] == 1) {
            return -1;
        }
        if (col == 0 && grid[row][col] == -1) {
            return -1;
        }
        if (grid[row][col] != grid[row][col + grid[row][col]]) {
            return -1;
        }
        if (row == N - 1) {
            return col + grid[row][col];
        }
        return process(grid, row + 1, col + grid[row][col]);
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}, {1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}};
        System.out.println(findBall(grid));
    }

}
