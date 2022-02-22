package lessons.dp;

/**
 * 机器人必须走 K 步，最终能来到P位置的方法有多少种
 * <p>
 * 假设有排成一行的N个位置，记为1~N，N 一定大于或等于 2开始时机器人在其中的M位置上(M 一定是 1~N 中的一个)
 * 如果机器人来到1位置，那么下一步只能往右来到2位置；
 * 如果机器人来到N位置，那么下一步只能往左来到 N-1 位置；
 * 如果机器人来到中间位置，那么下一步可以往左走或者往右走；
 * 规定机器人必须走 K 步，最终能来到P位置(P也是1~N中的一个)的方法有多少种
 * 给定四个参数 N、M、K、P，返回方法数。
 *
 * @author chensy6
 * @CreateDate 2022/2/22 14:36
 **/
public class RabotWalk {

    /**
     * 机器人必须走 K 步，最终能来到P位置的方法有多少种
     *
     * @param N 所有的位置
     * @param M 初始位置
     * @param K 需要走的步数
     * @param P 需要到达的目的地
     * @return
     */
    public static int walk1(int N, int M, int K, int P) {
        if (N < 2 || M > N || M < 2 || K == 0 || P > N || P < 2) {
            return 0;
        }
        return dfs(N, M, K, P);
    }

    /**
     * @param N    所有的位置
     * @param cur  当前所在位置
     * @param rest 剩余多少步
     * @param p    目的地
     * @return
     */
    public static int dfs(int N, int cur, int rest, int p) {
        if (rest == 0) {
            return cur == p ? 1 : 0;
        }
        if (cur == 1) {
            return dfs(N, 2, rest - 1, p);
        }
        if (cur == N) {
            return dfs(N, N - 1, rest - 1, p);
        }
        return dfs(N, cur - 1, rest - 1, p) + dfs(N, cur + 1, rest - 1, p);
    }

    public static int walk2(int N, int M, int K, int P) {
        if (N < 2 || M > N || M < 2 || K == 0 || P > N || P < 2) {
            return 0;
        }

        int[][] dp = new int[N + 1][K + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                dp[i][j] = -1;
            }
        }
        return dp1(N, M, K, P, dp);
    }

    public static int dp1(int N, int cur, int rest, int p, int[][] dp) {
        if (dp[cur][rest] != -1) {
            return dp[cur][rest];
        }
        int ans = 0;
        if (rest == 0) {
            ans = cur == p ? 1 : 0;
        } else if (cur == 1) {
            ans = dp1(N, 2, rest - 1, p, dp);
        } else if (cur == N) {
            ans = dp1(N, N - 1, rest - 1, p, dp);
        } else {
            ans = dp1(N, cur - 1, rest - 1, p, dp) + dp1(N, cur + 1, rest - 1, p, dp);
        }
        dp[cur][rest] = ans;
        return ans;
    }

    public static int walk3(int N, int M, int K, int P) {
        if (N < 2 || M > N || M < 2 || K == 0 || P > N || P < 2) {
            return 0;
        }

        int[][] dp = new int[N + 1][K + 1];
        dp[P][0] = 1;
        for (int rest = 1; rest <= K; rest++) {
            dp[1][rest] = dp[2][rest - 1];
            for (int j = 1; j <= N - 1; j++) {
                dp[j][rest] = dp[j - 1][rest - 1] + dp[j + 1][rest - 1];
            }
            dp[N][rest] = dp[N - 1][rest - 1];
        }
        return dp[M][K];
    }

    public static void main(String[] args) {
        System.out.println(walk1(6, 4, 5, 3));
        System.out.println(walk2(6, 4, 5, 3));
        System.out.println(walk3(6, 4, 5, 3));
    }

}
