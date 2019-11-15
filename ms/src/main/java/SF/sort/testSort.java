package SF.sort;

import java.util.Arrays;

/**
 * @ClassName testSort
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 11/15/2019 8:57 AM
 **/
public class testSort {

    /**
     * 就是个查找基准值下标的过程
     * 1 定一个基准值，定义一个low，high
     * 2 开始循环判断
     * 3 先从数组的尾部开始扫描，当基准值大于尾部元素，low和high交换位置
     * 4 在从数组的头部开始扫描，当基准值小于头部元素，low和high交换位置
     * 5 直到low>=high，返回low的位置，第一次循环结束
     * 6 将下标前后的数组重复以上步骤，直到前后数组都排序完后，所有元素排序结束
     */

    private static int getIndex(int[] arr, int low, int high) {
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
        if (arr != null && arr.length > 0 && low < high) {
            int index = getIndex(arr, low, high);
            quickSort(arr, index + 1, high);
            quickSort(arr, low, index - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 6, 4, 3, 2, 67, 3, 2, 5, 7, 0, 0, -1, -9};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


}
