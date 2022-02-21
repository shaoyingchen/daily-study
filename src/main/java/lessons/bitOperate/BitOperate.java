package lessons.bitOperate;

/**
 * 位运算
 *
 * @author chensy6
 * @CreateDate 2022/1/20 09:46
 **/
public class BitOperate {

    /**
     * 不使用中间变量交换两个数
     *
     * @param nums
     * @param i
     * @param j
     */
    public void change(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    /**
     * 数组中只有一个数出现了奇数次，其余数出现了偶数次，找出并返回这个数
     *
     * @param nums
     * @return
     */
    public int appearOddNum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }

    /**
     * 数组中只有两个数出现了奇数次，其余数出现了偶数次，找出并输出这两个数
     *
     * @param nums
     */
    public void searchTwoNum(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int N = nums.length;
        int onlyOne = nums[0];
        for (int i = 1; i < N; i++) {
            onlyOne ^= nums[i];
        }
        //提取出最右侧的1
        int rightOne = onlyOne & (~onlyOne + 1);
        int theOne = 0;
        for (int i = 0; i < N; i++) {
            if ((rightOne & nums[i]) == 0) {
                theOne ^= nums[i];
            }
        }
        System.out.println(theOne + "_" + (onlyOne ^ theOne));
    }

}
