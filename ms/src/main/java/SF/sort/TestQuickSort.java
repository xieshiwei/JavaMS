package SF.sort;

import java.util.Arrays;

public class TestQuickSort {

    public static int getIndex(int low, int high, int[] arr) {
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

    public static void quickSort(int low, int high, int[] arr) {
        if (arr != null && arr.length > 0 && low < high) {
            int index = getIndex(low, high, arr);
            quickSort(low, index - 1, arr);
            quickSort(index + 1, high, arr);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, -2, 100, 86, 99, 34, 45};
        quickSort(0, arr.length - 1, arr);
        System.out.println(Arrays.toString(arr));
    }

}
