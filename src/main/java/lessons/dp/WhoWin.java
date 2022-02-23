package lessons.dp;

/**
 * A,B玩家从左右两边拿纸牌,返回最后获胜者的分数
 * <p>
 * 给定一个整型数组arr，代表数值不同的纸牌排成一条线，   玩家A和玩家B依次拿走每张纸牌，
 * 规定玩家A先拿，玩家B后拿，
 * 但是每个玩家每次只能拿走最左或最右的纸牌，
 * 玩家A和玩家B都绝顶聪明。请返回最后获胜者的分数
 *
 * @author chensy6
 * @CreateDate 2022/2/22 15:16
 **/
public class WhoWin {

    public static int win(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int p1 = f(arr, 0, arr.length - 1);
        int p2 = g(arr, 0, arr.length - 1);
        return Math.max(p1, p2);
    }

    /**
     * 在arr[L...R]上先手
     *
     * @param arr
     * @param L
     * @param R
     * @return
     */
    public static int f(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int p1 = arr[L] + g(arr, L + 1, R);
        int p2 = arr[R] + g(arr, L, R - 1);
        return Math.max(p1, p2);
    }

    /**
     * 在arr[L...R]上后手
     *
     * @param arr
     * @param L
     * @param R
     * @return
     */
    public static int g(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        int p1 = f(arr, L + 1, R);
        int p2 = f(arr, L, R - 1);
        return Math.min(p1, p2);
    }

    public static int win2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int N = arr.length;
        int[][] fdp = new int[N][N];
        int[][] gdp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                fdp[i][j] = -1;
                gdp[i][j] = -1;
            }
        }
        int p1 = f2(arr, 0, N - 1, fdp, gdp);
        int p2 = g2(arr, 0, N - 1, fdp, gdp);
        return Math.max(p1, p2);
    }

    public static int f2(int[] arr, int L, int R, int[][] fdp, int[][] gdp) {
        if (fdp[L][R] != -1) {
            return fdp[L][R];
        }
        int ans = 0;
        if (L == R) {
            ans = arr[L];
        } else {
            int p1 = arr[L] + g2(arr, L + 1, R, fdp, gdp);
            int p2 = arr[R] + g2(arr, L, R - 1, fdp, gdp);
            ans = Math.max(p1, p2);
        }
        fdp[L][R] = ans;
        return ans;
    }

    public static int g2(int[] arr, int L, int R, int[][] fdp, int[][] gdp) {
        if (gdp[L][R] != -1) {
            return gdp[L][R];
        }
        int ans = 0;
        if (L != R) {
            int p1 = f2(arr, L + 1, R, fdp, gdp);
            int p2 = f2(arr, L, R - 1, fdp, gdp);
            ans = Math.min(p1, p2);
        }
        gdp[L][R] = ans;
        return ans;
    }

}
