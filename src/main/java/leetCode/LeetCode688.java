package leetCode;

/**
 * 688. 骑士在棋盘上的概率
 * <p>
 * 在一个n x n的国际象棋棋盘上，一个骑士从单元格 (row, column)开始，并尝试进行 k 次移动。行和列是 从 0 开始 的，所以左上单元格是 (0,0) ，右下单元格是 (n - 1, n - 1) 。
 * <p>
 * 象棋骑士有8种可能的走法，如下图所示。每次移动在基本方向上是两个单元格，然后在正交方向上是一个单元格。
 *
 * @author chensy6
 * @CreateDate 2022/2/17 09:44
 **/
public class LeetCode688 {

    /**
     * 输入: n = 3, k = 2, row = 0, column = 0
     * 输出: 0.0625
     * 解释: 有两步(到(1,2)，(2,1))可以让骑士留在棋盘上。
     * 在每一个位置上，也有两种移动可以让骑士留在棋盘上。
     * 骑士留在棋盘上的总概率是0.0625。
     *
     * @param n
     * @param k
     * @param row
     * @param column
     * @return
     */
    public double knightProbability(int n, int k, int row, int column) {
        double total = Math.pow(8, k);
        Double[][][] cache = new Double[n][n][k + 1];
        double in = dfs(row, column, k, n, cache);
        return in / total;
    }

    public double dfs(int x, int y, int k, int n, Double[][][] cache) {
        if (x < 0 || y < 0 || x > n - 1 || y > n - 1) {
            return 0;
        }

        if (k == 0) {
            return 1;
        }

        if (cache[x][y][k] != null) {
            return cache[x][y][k];
        }

        double res = 0;
        res += dfs(x - 1, y - 2, k - 1, n, cache);
        res += dfs(x - 1, y + 2, k - 1, n, cache);
        res += dfs(x + 1, y - 2, k - 1, n, cache);
        res += dfs(x + 1, y + 2, k - 1, n, cache);
        res += dfs(x + 2, y - 1, k - 1, n, cache);
        res += dfs(x - 2, y - 1, k - 1, n, cache);
        res += dfs(x + 2, y + 1, k - 1, n, cache);
        res += dfs(x - 2, y + 1, k - 1, n, cache);

        cache[x][y][k] = res;

        return res;
    }

}
