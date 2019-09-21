package SF.sort;

import java.util.Arrays;

public class TestQuickSort {

    /**
     * 定义一个基准数
     * 从右向左循环排序
     * 从左向右循环排序
     *
     * @param low
     * @param high
     * @param arr
     */
    public static void quickSort(int low, int high, int[] arr) {
        if (arr != null && arr.length > 0 && low < high) {
            //获取基准数
            int index = getIndex(low, high, arr);
            //从左往右
            quickSort(low, index - 1, arr);
            //从右往左
            quickSort(index + 1, high, arr);
        }
    }

    /**
     * 获取基准数下标
     *
     * @param low
     * @param high
     * @param arr
     * @return
     */
    public static int getIndex(int low, int high, int[] arr) {
        if (arr == null || arr.length <= 0) {
            return -1;
        }
        int temp = arr[low];
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

    public static void main(String[] args) {
        int[] nums = {49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22};
        System.out.println(Arrays.toString(nums));
        quickSort(0, nums.length - 1, nums);
        System.out.println(Arrays.toString(nums));
    }


}
