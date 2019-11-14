package SF.sort;

/**
 * @ClassName TestBinarySearch
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 9/10/2019 7:58 AM
 **/
public class TestBinarySearch {

    /**
     * 数组必须是排好序的
     * 1 定一个low,high标记
     * 2 通过low+high/2的计算拿到中间值
     * 3 判断比较的数组与中间值的大小
     * 4 大于中间值，最小值取中间值+1，最大值取数组最大下标
     * 5 小鱼中间值，最小值取数组第一个下标，最大值取中间值下标-1
     * 6 循环以上逻辑判断
     */

    public static int recusionBrinarySearch(int[] arr, int low, int high, int index) {
        if (index < arr[low] || index > arr[high] || low > high) {
            return -1;
        }
        int middle = (low + high) / 2;
        if (index > arr[middle]) {
            return recusionBrinarySearch(arr, middle + 1, high, index);
        } else if (index < arr[middle]) {
            return recusionBrinarySearch(arr, low, middle - 1, index);
        } else {
            return middle;
        }
    }

    public static int getIndex(int[] arr, int index) {
        if (arr == null || arr.length <= 0) {
            return -1;
        }
        int low = 0;
        int high = arr.length - 1;
        int middle = 0;
        while (low <= high) {
            middle = (low + high) / 2;
            if (index > arr[middle]) {
                low = middle + 1;
            } else if (index < arr[middle]) {
                high = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        int index = 10;
        System.out.println(getIndex(arr, index));
        System.out.println(recusionBrinarySearch(arr, 0, arr.length - 1, index));
    }

}
