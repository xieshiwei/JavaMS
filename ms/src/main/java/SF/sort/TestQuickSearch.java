package SF.sort;

import java.util.Arrays;

/**
 * @ClassName TestQuickSearch
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 10/31/2019 10:01 AM
 **/
public class TestQuickSearch {

    /**
     * 查找基准值下标的过程
     * 1 定义一个基准值
     * 2 从数组的左边和右边开始扫描，定义一个low,high的标记
     * 3 基准值小于左边元素low,high交换位置
     * 4 基准值大于右边元素low,high交换位置
     * 5 直到low>=high返回Low的位置
     * 6 第一次循环结束
     * 7 继续循环基准值左边，右边的数组，直到全部排序结束
     */

    public static int getIndex(int[] arr, int low, int high) {
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

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int index = getIndex(arr, low, high);
            quickSort(arr, low, index - 1);
            quickSort(arr, index + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = {7, 5, 3, 8, 1, 0, -1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


}
