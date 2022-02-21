package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1447. 最简分数
 * <p>
 * 给你一个整数 n ，请你返回所有 0 到 1 之间（不包括 0 和 1）满足分母小于等于  n 的 最简 分数 。分数可以以 任意 顺序返回。
 *
 * @author chensy6
 * @CreateDate 2022/2/10 09:20
 **/
public class LeetCode1447 {

    /**
     * 输入：n = 3
     * 输出：["1/2","1/3","2/3"]
     *
     * @param n
     * @return
     */
    public List<String> simplifiedFractions(int n) {
        List<String> ans = new ArrayList<>();
        if (n <= 1) {
            return ans;
        }
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (gcd(i, j) == 1) {
                    ans.add(i + "/" + j);
                }
            }
        }
        return ans;
    }

    /**
     * 欧几里得算法
     * <p>
     * 如何快速判断两个数组成的分数是否为最简（即判断两个数的最大公约数是否为1）。
     *
     * @param a
     * @param b
     * @return
     */
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
