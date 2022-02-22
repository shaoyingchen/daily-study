package lessons.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印一个字符串的全排列
 *
 * @author chensy6
 * @CreateDate 2022/2/22 13:55
 **/
public class AllSeq {

    public static List<String> allSeq1(String str) {
        List<String> ans = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return ans;
        }
        List<Character> rest = new ArrayList<>();
        char[] strs = str.toCharArray();
        for (char c : strs) {
            rest.add(c);
        }
        fun1(rest, "", ans);
        return ans;
    }

    /**
     * 粗糙的尝试
     *
     * @param rest  已经做完决定所剩余的字符
     * @param path  当前的字符串
     * @param ans
     */
    public static void fun1(List<Character> rest, String path, List<String> ans) {
        if (rest.isEmpty()) {
            ans.add(path);
            return;
        }
        for (int i = 0; i < rest.size(); i++) {
            //选择了当前的字符，将当前字符从剩余集合删除
            char c = rest.remove(i);
            fun1(rest, path + c, ans);
            //恢复现场
            rest.add(i, c);
        }
    }

    public static List<String> allSeq2(String str) {
        List<String> ans = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return ans;
        }

        char[] chars = str.toCharArray();
        fun2(chars, 0, ans);
        return ans;
    }

    /**
     * 好的尝试
     *
     * @param strs  strs[0...index-1] 已经做好的决定，不要动了
     * @param index strs[index...] 都有机会来到index位置
     * @param ans   最终结果
     */
    public static void fun2(char[] strs, int index, List<String> ans) {
        if (index == strs.length) {
            ans.add(new String(strs));
            return;
        }
        //如果index没有终止，index之后的所有字符都有机会来到index位置
        for (int i = index; i < strs.length; i++) {
            //每一步选择谁做index位置的字符
            swap(strs, index, i);
            fun2(strs, index + 1, ans);
            //恢复现场
            swap(strs, index, i);
        }
    }

    public static void swap(char[] strs, int i, int j) {
        char c = strs[i];
        strs[i] = strs[j];
        strs[j] = c;
    }

    public static void main(String[] args) {
        System.out.println(allSeq1("abc"));
        System.out.println(allSeq2("abc"));
    }

}
