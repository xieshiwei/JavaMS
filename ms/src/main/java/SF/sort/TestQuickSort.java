package SF.sort;

import java.util.Arrays;


/**
 * 1.找一个基准值
 * 2.从高到底扫描比较，互换位置
 * 3.从低到高扫描比较，互换位置
 * 4.用递归分别对基准值左右两边的数组重新排列顺序
 */
public class TestQuickSort {


    /**
     * 快排
     *
     * @param low
     * @param high
     * @param arr
     */
    public static void quickSort(int low, int high, int[] arr) {
        if (low < high) {
            int index = getIndex(low, high, arr);
            quickSort(low, index - 1, arr);
            quickSort(index + 1, high, arr);
        }
    }

    /**
     * 返回基准值
     *
     * @param low
     * @param high
     * @param arr
     * @return
     */
    public static int getIndex(int low, int high, int[] arr) {
        //基准值
        int index = arr[low];
        while (low < high) {
            while (low < high && index <= arr[high]) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && index >= arr[low]) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = index;
        return low;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 23, 1, 78, 12, 1, 56, -1, 0, 3};
        quickSort(0, arr.length - 1, arr);
        System.out.println(Arrays.toString(arr));

    }

}
