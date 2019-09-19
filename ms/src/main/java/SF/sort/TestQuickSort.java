package SF.sort;

import java.util.Arrays;

public class TestQuickSort {

    public static void main(String[] args) {
        int[] nums = {49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22};
        System.out.println("排序之前的数组为...............");
        System.out.println(Arrays.toString(nums));
        System.out.println("排序之后的数组为...............");
        quickSort(0, nums.length - 1, nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int low, int high, int[] arr) {

        if (low < high) {

            //获取基准数
            int index = getIndex(low, high, arr);
            //从基准数左边开始排序
            quickSort(low, index - 1, arr);
            //从基准值右边开始排序
            quickSort(index + 1, high, arr);

        }
    }

    /**
     * 返回基准数下标
     *
     * @param low
     * @param high
     * @param arr
     * @return
     */
    public static int getIndex(int low, int high, int[] arr) {

        //当前元素第一个作为基准数
        int temp = arr[low];

        //循环所有数组，计算出基准数
        while (low < high) {
            while (low < high && temp <= arr[high]) {
                high--;
            }
            arr[low] = arr[high];


            while (low < high && temp >= arr[low]) {
                low++;
            }
            arr[high] = arr[low];

        }
        arr[low] = temp;
        return low;
    }


}
