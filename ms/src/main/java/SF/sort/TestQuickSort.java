package SF.sort;


import java.util.Arrays;

/**
 *
 */
public class TestQuickSort {

    public static void quicSort(int low, int high, int[] arr) {
        if (low < high) {
            int index = getIndex(low, high, arr);
            quicSort(low, index - 1, arr);
            quicSort(index + 1, high, arr);
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
        int[] arr = {4, 2, 67, 44, 2, 7, 2, 6, 9, -1};
        quicSort(0, arr.length - 1, arr);
        System.out.println(Arrays.toString(arr));
    }


}
