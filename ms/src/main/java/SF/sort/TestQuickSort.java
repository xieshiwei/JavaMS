package SF.sort;

import java.util.Arrays;

public class TestQuickSort {


    public static void main(String[] args) {
        int[] nums = {49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22};
        System.out.println("排序之前的数组为...............");
        System.out.println(Arrays.toString(nums));
        System.out.println("排序之后的数组为...............");
        quitSort(0, nums.length - 1, nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void quitSort(int low, int high, int[] arr) {

        if (low < high) {
            int index = getIndex(low, high, arr);
            quitSort(low, index - 1, arr);
            quitSort(index + 1, high, arr);
        }
    }

    public static int getIndex(int low, int high, int[] arr) {

        //取当前第一位为基准数
        int temp = arr[low];

        while (low < high) {
            //right to left
            while (low < high && temp <= arr[high]) {
                high--;
            }
            arr[low] = arr[high];

            //left to right
            while (low < high && temp >= arr[low]) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = temp;
        return low;
    }


}
