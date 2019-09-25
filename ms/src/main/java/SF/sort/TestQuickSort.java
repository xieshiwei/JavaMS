package SF.sort;

import java.util.Arrays;

public class TestQuickSort {

    public static void quitSort(int low, int high, int[] arr) {
        if (arr != null && arr.length > 0 && low < high) {
            int index = getNum(low, high, arr);
            quitSort(low, index - 1, arr);
            quitSort(index + 1, high, arr);
        }
    }

    public static int getNum(int low, int high, int[] arr) {
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
        int[] arr = {3, 5, 1, 0, 99, 82, 33, 25};
        quitSort(0, arr.length - 1, arr);
        System.out.println(Arrays.toString(arr));
    }
}
