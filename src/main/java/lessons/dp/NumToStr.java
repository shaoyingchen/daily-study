package lessons.dp;

/**
 * 数字转化为字符串的结果数
 * <p>
 * 规定1和A对应、2和B对应、3和C对应...  那么一个数字字符串比如"111”就可以转化为:
 * "AAA"、"KA"和"AK"
 * 给定一个只有数字字符组成的字符串str，返回有多少种转化结果
 *
 * @author chensy6
 * @CreateDate 2022/2/23 14:35
 **/
public class NumToStr {

    public static int numToStr(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] strs = str.toCharArray();
        return process(strs, 0);
    }

    public static int process(char[] strs, int index) {
        if (index == strs.length) {
            return 1;
        }
        if (strs[index] == '0') {
            return 0;
        }
        int ans = process(strs, index + 1);
        if (index + 1 < strs.length && (strs[index] - '0') * 10 + strs[index + 1] - '0' < 27) {
            ans += process(strs, index + 2);
        }
        return ans;
    }

    public static int numToStr2(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] strs = str.toCharArray();
        int N = strs.length;
        int[] dp = new int[N + 1];
        dp[N] = 1;
        for (int i = N - 1; i >= 0; i--) {
            int ans = dp[i + 1];
            if (i + 1 < N && (strs[i] - '0') * 10 + strs[i + 1] - '0' < 27) {
                ans += dp[i+2];
            }
            dp[i] = ans;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(numToStr("1314567"));
        System.out.println(numToStr2("1314567"));
    }

}
