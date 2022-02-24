package lessons.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串str，给定一个字符串类型的数组arr。
 * arr里的每一个字符串，代表一张贴纸，你可以把单个字符剪开使用，目的是拼出str来。
 * 返回需要至少多少张贴纸可以完成这个任务。
 * 例子：str= "babac"，arr = {"ba","c","abcd"}
 * 至少需要两张贴纸"ba"和"abcd"，因为使用这两张贴纸，把每一个字符单独剪开，含有2个a、2个b、1个c。是可以拼出str的。所以返回2。
 *
 * @author chensy6
 * @CreateDate 2022/2/24 10:42
 **/
public class Stickers {

    /**
     * 输入： stickers = ["with","example","science"], target = "thehat"
     * 输出：3
     * 解释：
     * 我们可以使用 2 个 "with" 贴纸，和 1 个 "example" 贴纸。
     * 把贴纸上的字母剪下来并重新排列后，就可以形成目标 “thehat“ 了。
     * 此外，这是形成目标字符串所需的最小贴纸数量。
     *
     * @param stickers
     * @param target
     * @return
     */
    public static int minStickers(String[] stickers, String target) {
        if (stickers == null || stickers.length == 0) {
            return 0;
        }
        Map<String, Integer> dp = new HashMap<>();
        //int ans = process(stickers, target);
        int ans = process1(stickers, target, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static int process(String[] stickers, String target) {
        //如果target为空，说明已经全部都替换完成
        if ("".equals(target)) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (String str : stickers) {
            //用str替换target中的字符
            String rest = minus(str, target);
            //如果替换完，剩余字符的长度没变，说明没有可以替换的字符了
            if (rest.length() != target.length()) {
                //否则将剩余字符继续进行尝试
                min = Math.min(min, process(stickers, rest));
            }
        }
        //1是str这张贴纸
        return min + (min == Integer.MAX_VALUE ? 0 : 1);
    }

    public static int process1(String[] stickers, String target, Map<String, Integer> dp) {
        //如果target为空，说明已经全部都替换完成
        if ("".equals(target)) {
            return 0;
        }

        if (dp.containsKey(target)) {
            return dp.get(target);
        }

        int min = Integer.MAX_VALUE;
        for (String str : stickers) {
            //用str替换target中的字符
            String rest = minus(str, target);
            //如果替换完，剩余字符的长度没变，说明没有可以替换的字符了
            if (rest.length() != target.length()) {
                //否则将剩余字符继续进行尝试
                min = Math.min(min, process1(stickers, rest, dp));
            }
        }
        int ans = min + (min == Integer.MAX_VALUE ? 0 : 1);
        dp.put(target, ans);
        //1是str这张贴纸
        return ans;
    }

    public static String minus(String str, String rest) {
        int[] rests = new int[27];
        char[] chars = str.toCharArray();
        char[] chars1 = rest.toCharArray();
        for (char c : chars1) {
            rests[c - 'a']++;
        }
        for (char c : chars) {
            rests[c - 'a']--;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <= 26; i++) {
            if (rests[i] > 0) {
                char c = (char) ('a' + i);
                for (int j = 0; j < rests[i]; j++) {
                    builder.append(c);
                }
            }
        }
        return new String(builder);
    }

    public static void main(String[] args) {
        String[] strickers = new String[]{"with", "example", "science"};
        String target = "thehat";
        System.out.println(minStickers(strickers, target));
    }

}
