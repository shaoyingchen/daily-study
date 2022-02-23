package lessons.dp;

/**
 * 背包问题（背包能装下最多的价值）
 * <p>
 * 给定两个长度都为N的数组weights和values，weights[i]和values[i]分别代表 i号物品的重量和价值。
 * 给定一个正数bag，表示一个载重bag的袋子，
 * 你装的物品不能超过这个重量。
 *
 * @author chensy6
 * @CreateDate 2022/2/23 14:11
 **/
public class Knapsack {

    public static int maxValue(int[] weights, int[] values, int bag) {
        if (weights == null || values == null || bag < 0 || weights.length != values.length) {
            return 0;
        }
        return process(weights, values, 0, bag);
    }

    public static int process(int[] weights, int[] values, int index, int rest) {
        if (rest < 0) {
            return -1;
        }
        if (index == weights.length) {
            return 0;
        }
        int p1 = process(weights, values, index + 1, rest);
        int p2 = 0;
        int next = process(weights, values, index + 1, rest - weights[index]);
        if (next != -1) {
            p2 = values[index] + next;
        }
        return Math.max(p1, p2);
    }

    public static int maxValue1(int[] weights, int[] values, int bag) {
        if (weights == null || values == null || bag < 0 || weights.length != values.length) {
            return 0;
        }
        int N = weights.length;
        int[][] dp = new int[N + 1][bag + 1];

        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= bag; rest++) {
                int p1 = dp[index + 1][rest];
                int p2 = 0;
                if (rest - weights[index] >= 0) {
                    p2 = values[index] + dp[index + 1][rest - weights[index]];
                }
                dp[index][rest] = Math.max(p1, p2);
            }
        }
        return dp[0][bag];
    }

    public static void main(String[] args) {
        int[] w = new int[]{10, 4, 8, 23};
        int[] v = new int[]{1, 5, 12, 4};
        int bag = 20;
        System.out.println(maxValue(w, v, bag));
        System.out.println(maxValue1(w, v, bag));
    }

}
