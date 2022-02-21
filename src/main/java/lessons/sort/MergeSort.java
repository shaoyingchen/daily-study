package lessons.sort;

/**
 * 归并排序
 *
 * @author chensy6
 * @CreateDate 2022/1/20 10:18
 **/
public class MergeSort {

    public void sort(int[] nums) {

    }

    public void process(int[] nums, int L, int R) {
        if (L == R) {
            return;
        }
        int M = L + ((R - L) >> 1);
        process(nums, L, M);
        process(nums, M + 1, R);
        merge(nums, L, M, R);
    }

    public void merge(int[] nums, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int lIndex = L, rIndex = M + 1, helpIndex = 0;
        while (lIndex <= M && rIndex <= R) {
            help[helpIndex++] = nums[lIndex] <= nums[rIndex] ? nums[lIndex++] : nums[rIndex++];
        }
        while (lIndex <= M) {
            help[helpIndex++] = nums[lIndex++];
        }
        while (rIndex <= R) {
            help[helpIndex++] = nums[rIndex++];
        }
        for (int i = 0; i < R - L + 1; i++) {
            nums[L + i] = help[i];
        }
    }

}
