package lessons.dp;

/**
 * 最长回文子序列
 * 范围尝试模型：考虑开头和结尾的可能性
 * <p>
 * 给定一个字符串str，求最长回文子序列长度
 *
 * @author chensy6
 * @CreateDate 2022/2/25 14:35
 **/
public class LongestPalindromeSubseq {

    /**
     * 求字符串的最长回文子序列
     *
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        return process(chars, 0, chars.length - 1);
    }

    /**
     * 求[L...R]上的最长回文子序列
     *
     * @param strs
     * @param L
     * @param R
     * @return
     */
    public int process(char[] strs, int L, int R) {
        if (L == R) {
            return 1;
        }
        if (L == R - 1) {
            return strs[L] == strs[R] ? 2 : 1;
        }
        //最长回文子序列既不以L开头，也不以R结尾
        int p1 = process(strs, L + 1, R - 1);
        //以L开头，不以R结尾
        int p2 = process(strs, L, R - 1);
        //不以L开头，以R结尾
        int p3 = process(strs, L + 1, R);
        //既以L开头，又以R结尾
        int p4 = strs[L] != strs[R] ? 0 : process(strs, L + 1, R - 1) + 2;
        return Math.max(Math.max(p1, p2), Math.max(p3, p4));
    }

    public int longestPalindromeSubseq1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int N = chars.length;
        int[][] dp = new int[N][N];
        dp[N - 1][N - 1] = 1;
        for (int i = 0; i < N - 1; i++) {
            dp[i][i] = 1;
            dp[i][i + 1] = chars[i] == chars[i + 1] ? 2 : 1;
        }

        for (int L = N - 3; L >= 0; L--) {
            for (int R = L + 2; R < N; R++) {
                int p1 = dp[L][R - 1];
                //不以L开头，以R结尾
                int p2 = dp[L + 1][R];
                //既以L开头，又以R结尾
                int p3 = chars[L] != chars[R] ? 0 : dp[L + 1][R - 1] + 2;
                dp[L][R] = Math.max(p1, Math.max(p2, p3));
            }
        }
        return dp[0][N - 1];
    }

}
