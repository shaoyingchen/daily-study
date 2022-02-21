package leetCode;

import java.util.Arrays;

/**
 * 1984. 学生分数的最小差值
 * <p>
 * 给你一个 下标从 0 开始 的整数数组 nums ，其中 nums[i] 表示第 i 名学生的分数。另给你一个整数 k 。
 * <p>
 * 从数组中选出任意 k 名学生的分数，使这 k 个分数间 最高分 和 最低分 的 差值 达到 最小化 。
 * <p>
 * 返回可能的 最小差值 。
 *
 * @author chensy6
 * @CreateDate 2022/2/11 09:27
 **/
public class LeetCode1984 {

    /**
     * 输入：nums = [9,4,1,7], k = 2
     * 输出：2
     * 解释：选出 2 名学生的分数，有 6 种方法：
     * - [9,4,1,7] 最高分和最低分之间的差值是 9 - 4 = 5
     * - [9,4,1,7] 最高分和最低分之间的差值是 9 - 1 = 8
     * - [9,4,1,7] 最高分和最低分之间的差值是 9 - 7 = 2
     * - [9,4,1,7] 最高分和最低分之间的差值是 4 - 1 = 3
     * - [9,4,1,7] 最高分和最低分之间的差值是 7 - 4 = 3
     * - [9,4,1,7] 最高分和最低分之间的差值是 7 - 1 = 6
     * 可能的最小差值是 2
     *
     * @param nums
     * @param k
     * @return
     */
    public int minimumDifference(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 1) {
            return 0;
        }
        Arrays.sort(nums);
        int ans = nums[k - 1] - nums[0];
        for (int i = k; i < nums.length; i++) {
            ans = Math.min(ans, nums[i] - nums[i - k + 1]);
        }
        return ans;
    }

}
