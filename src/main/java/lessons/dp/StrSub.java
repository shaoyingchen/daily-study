package lessons.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印一个字符串的全部子序列
 *
 * @author chensy6
 * @CreateDate 2022/2/22 09:37
 **/
public class StrSub {

    public static List<String> subs(String str) {
        List<String> ans = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return ans;
        }

        char[] strs = str.toCharArray();
        String path = "";
        fun(strs, 0, path, ans);
        return ans;
    }

    public static void fun(char[] strs, int index, String path, List<String> ans) {
        if (index == strs.length) {
            ans.add(path);
            return;
        }
        //当前位置要
        fun(strs, index + 1, path, ans);
        //当前位置不要
        fun(strs, index + 1, path + strs[index], ans);
    }

    public static void main(String[] args) {
        System.out.println(subs("abc"));
    }

}
