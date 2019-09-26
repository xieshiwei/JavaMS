package SF.sort;

import java.util.Arrays;

/**
 * @ClassName QuickSort
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 8/27/2019 8:14 PM
 **/
public class QuickSort {


    /**
     * 快速排序,说白了就是给基准数据找其正确索引位置的过程.
     * 首先在数组中选择一个基准点
     * 然后分别从数组的两端扫描数组，设两个指示标志（low指向起始位置，high指向末尾)
     *  首先从后半部分开始，如果发现有元素比该基准点的值小，就交换low和high位置的值
     *  然后从前半部分开始扫秒，发现有元素大于基准点的值，就交换low和high位置的值
     * 如此往复循环，直到low>=high,然后把基准点的值放到high这个位置。
     * 一次排序就完成了。以后采用递归的方式分别对前半部分和后半部分排序
     * 当前半部分和后半部分均有序时该数组就自然有序了。
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22};
        System.out.println("排序之前的数组为...............");
        System.out.println(Arrays.toString(nums));
        System.out.println("排序之后的数组为...............");
        //使用选择排序算法进行排序：
        QuickSort sort = new QuickSort();
        sort.quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int index = getIndex(arr, low, high);
            //对左子序列进行排序
            quickSort(arr, low, index - 1);
            //对右子序列进行排序
            quickSort(arr, index + 1, high);
        }
    }

    /**
     * 获取基准数下标
     * @param nums
     * @param low
     * @param high
     * @return
     */
    private int getIndex(int[] nums, int low, int high) {
        //当前数组的第一个元素作为中轴（基准）
        int temp = nums[low];
        while (low < high) {
            //这里temp <= nums[high]中等号的情况相当于数组中出现了两个相等的数字，循环比较依然能够继续
            while (low < high && temp <= nums[high]) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && temp >= nums[low]) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = temp;
        return low;
    }

}
