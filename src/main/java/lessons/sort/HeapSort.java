package lessons.sort;

/**
 * 堆排序
 *
 * @author chensy6
 * @CreateDate 2022/1/26 09:37
 **/
public class HeapSort {

    public void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int heapSize = nums.length;
        for (int i = 0; i < heapSize; i++) {
            heapInsert(nums, i);
        }

        swap(nums, 0, --heapSize);
        while (heapSize > 0) {
            heapify(nums, 0, heapSize);
            swap(nums, 0, --heapSize);
        }

    }

    public void heapInsert(int[] nums, int index) {
        while (nums[(index - 1) / 2] < nums[index]) {
            swap(nums, (index - 1) / 2, index);
            index = (index - 1) / 2;
        }
    }

    public void heapify(int[] nums, int index, int heapSize) {
        int left = index << 1 | 1;
        while (left < heapSize) {
            int larger = left + 1 < heapSize && nums[left + 1] > nums[left] ? left + 1 : left;
            larger = nums[index] > nums[larger] ? index : larger;
            if (larger == index) break;
            swap(nums, index, larger);
            index = larger;
            left = index << 1 | 1;
        }

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
