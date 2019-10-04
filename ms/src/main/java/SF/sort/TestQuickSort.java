package SF.sort;


import java.util.Arrays;

/**
 * 1.找基准值
 * 2.从左右两边扫描，如果不符合条件交换位置，左边最大，右边最小
 * 3.第一个排序结束后，将基准值左右两边的重新用想通的方法重新排序
 */
public class TestQuickSort {

    public static void quickSort(int low, int high, int[] arr) {
        if (low < high) {
            int index = getIndex(low, high, arr);
            quickSort(low, index - 1, arr);
            quickSort(index + 1, high, arr);
        }
    }

    private static int getIndex(int low, int high, int[] arr) {
        int index = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= index) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= index) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = index;
        return low;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 9, 77, 54, 2, 44, 0, -1, 22};
        quickSort(0, arr.length - 1, arr);
        System.out.println(Arrays.toString(arr));
    }


}
