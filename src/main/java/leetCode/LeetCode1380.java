package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1380. 矩阵中的幸运数
 *
 * 给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
 *
 * 幸运数是指矩阵中满足同时下列两个条件的元素：
 *
 * 在同一行的所有元素中最小
 * 在同一列的所有元素中最大
 *
 * @author chensy6
 * @CreateDate 2022/2/15 09:24
 **/
public class LeetCode1380 {

    /**
     * 输入：matrix = [[3,7,8],[9,11,13],[15,16,17]]
     * 输出：[15]
     * 解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
     *
     * @param matrix
     * @return
     */
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return ans;
        }
        int N = matrix.length;
        for (int i = 0; i < N; i++) {
            int rowmin = matrix[i][0];
            int col = 0;
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] < rowmin) {
                    rowmin = matrix[i][j];
                    col = j;
                }
            }
            int colmax = matrix[0][col];
            for (int j = 1; j < N; j++) {
                colmax = matrix[j][col] > colmax ? matrix[j][col] : colmax;
            }
            if (rowmin == colmax) {
                ans.add(rowmin);
            }
        }
        return ans;
    }

}
