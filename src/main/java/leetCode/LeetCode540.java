package leetCode;

/**
 * 540. 有序数组中的单一元素
 * <p>
 * 给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
 * <p>
 * 请你找出并返回只出现一次的那个数。
 * <p>
 * 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
 *
 * @author chensy6
 * @CreateDate 2022/2/14 09:53
 **/
public class LeetCode540 {

    /**
     * 输入: nums = [1,1,2,3,3,4,4,8,8]
     * 输出: 2
     *
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }

}
