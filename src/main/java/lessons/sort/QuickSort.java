package lessons.sort;

/**
 * 快排
 *
 * @author chensy6
 * @CreateDate 2022/1/24 17:08
 **/
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 7, 5, 9, 0, 1, 5};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void sort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        quickSort(nums, 0, nums.length - 1);
    }

    public static void quickSort(int[] nums, int L, int R) {
        if (L >= R) {
            return;
        }
        swap(nums, L + (int) (Math.random() * (R - L + 1)), R);
        int[] nearsLand = partition(nums, L, R);
        quickSort(nums, L, nearsLand[0] - 1);
        quickSort(nums, nearsLand[1] + 1, R);
    }


    public static int[] partition(int[] nums, int L, int R) {
        if (L > R) {
            return new int[]{-1, -1};
        }
        if (L == R) {
            return new int[]{L, R};
        }
        int less = L - 1;
        int more = R;
        int index = L;
        while (index < more) {
            if (nums[index] == nums[R]) {
                index++;
            } else if (nums[index] < nums[R]) {
                swap(nums, ++less, index++);
            } else {
                swap(nums, --more, index);
            }
        }
        swap(nums, more, R);
        return new int[]{less + 1, more};
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
