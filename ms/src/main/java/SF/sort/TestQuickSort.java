package SF.sort;

import java.util.Arrays;

public class TestQuickSort {

    public static void quitSort(int low, int high, int[] arr) {
        if (low < high) {
            int temp = getBasicNum(low, high, arr);
            quitSort(low, temp - 1, arr);
            quitSort(temp + 1, high, arr);
        }
    }


    /**
     * 获取基准值
     *
     * @param low
     * @param high
     * @param arr
     * @return
     */
    public static int getBasicNum(int low, int high, int[] arr) {
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
        int[] arr = {6, 3, 67, 0, 8, 18, 97, -2, 1};
        quitSort(0, arr.length - 1, arr);
        System.out.println(Arrays.toString(arr));
    }


}
