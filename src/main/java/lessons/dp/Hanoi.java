package lessons.dp;

/**
 * 汉诺塔问题，经典的递归
 *
 * @author chensy6
 * @CreateDate 2022/2/22 09:18
 **/
public class Hanoi {

    public void fun(int N, String from, String to, String other) {
        if (N == 1) {
            System.out.println("move " + N + " from " + from + " to " + to);
            return;
        }
        fun(N - 1, from, other, to);
        System.out.println("move " + N + " from " + from + " to " + to);
        fun(N - 1, other, to, from);
    }

}
