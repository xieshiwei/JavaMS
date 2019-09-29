package SF.sort;

import java.util.Arrays;

public class TestQuickSort {

    /**
     * 快排：
     * 1.找到一个基准点。
     * 2.分别从数组的两段扫描数组，设置两个标记分别表示头部和尾部。
     * 3.从后半部分开始扫描，如果发现有元素比该基准值小，就交换low和high位置的值。
     * 4.从前半部分开始扫描，如果有元素大于基准值的值，就交换low和high位置的值。
     * 5.扫描直到low>=high，然后把基准点的值放到low的位置，第一次排序就完成了。
     * 6.采用递归的方式分别对前半部分，后半部分排序。
     *
     * @param low
     * @param high
     * @param arr
     */
    public static void quickSort(int low, int high, int[] arr) {
        if (arr != null && arr.length > 0 && low < high) {
            int index = getIndex(low, high, arr);
            quickSort(low, index - 1, arr);
            quickSort(index + 1, high, arr);
        }
    }

    /**
     * 返回基准数
     *
     * @param low
     * @param high
     * @param arr
     * @return
     */
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

    public static void main(String[] args) {
        int[] arr = {3, 1, 6, 5, 9, 100, 120, 0, -1};
        quickSort(0, arr.length - 1, arr);
        System.out.println(Arrays.toString(arr));
    }


}
