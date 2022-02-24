package lessons.dp;

/**
 * 两个字符串的最长公共子序列（样本对应模型，考虑样本结尾位置的可能性）
 *
 * @author chensy6
 * @CreateDate 2022/2/24 15:35
 **/
public class StrSamePre {

    public static int samePre(String s1, String s2) {
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) {
            return 0;
        }
        char[] chars = s1.toCharArray();
        char[] chars1 = s2.toCharArray();
        return process(chars, chars1, chars.length - 1, chars1.length - 1);
    }

    public static int process(char[] str1, char[] str2, int i, int j) {
        if (i == 0 && j == 0) {
            return str1[i] == str2[j] ? 1 : 0;
        }
        if (i == 0) {
            return str1[i] == str2[j] ? 1 : process(str1, str2, i, j - 1);
        }
        if (j == 0) {
            return str1[i] == str2[j] ? 1 : process(str1, str2, i - 1, j);
        }
        //可能以i结尾，不以j结尾
        int p2 = process(str1, str2, i, j - 1);
        //可能以j结尾，不以i结尾
        int p3 = process(str1, str2, i - 1, j);
        //既以i结尾又以j结尾
        int p4 = str1[i] != str2[j] ? 0 : process(str1, str2, i - 1, j - 1) + 1;
        return Math.max(p2, Math.max(p3, p4));
    }

    public static int longestCommonSubsequence(String s1, String s2) {
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) {
            return 0;
        }
        char[] chars = s1.toCharArray();
        char[] chars1 = s2.toCharArray();
        int N = chars.length;
        int M = chars1.length;
        int[][] dp = new int[N][M];
        dp[0][0] = chars[0] == chars1[0] ? 1 : 0;
        for (int i = 1; i < M; i++) {
            dp[0][i] = chars[0] == chars1[i] ? 1 : dp[0][i - 1];
        }
        for (int i = 1; i < N; i++) {
            dp[i][0] = chars[i] == chars1[0] ? 1 : dp[i - 1][0];
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                int p2 = dp[i] [j - 1];
                //可能以j结尾，不以i结尾
                int p3 = dp[i - 1][j];
                //既以i结尾又以j结尾
                int p4 = chars[i] != chars1[j] ? 0 : dp[i - 1][j - 1] + 1;
                dp[i][j] = Math.max(p2, Math.max(p3, p4));
            }
        }
        return dp[N - 1][M - 1];
    }

    public static void main(String[] args) {
        System.out.println(samePre("12kj89hd", "h12ol89hbd"));
        System.out.println(longestCommonSubsequence("12kj89hd", "h12ol89hbd"));
    }

}
