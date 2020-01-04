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
     * low,high,计算middle下标
     * 将比较的书和middle下标的元素比较
     * 如果大于middle下标 low=middle+1,如果小于middle high=middle-1
     * 重复以上步骤知道查到数据
     */

    public static int getIndex(int[] arr, int num) {
        if (arr == null || arr.length <= 0) {
            return -1;
        }
        int high = arr.length - 1;
        int low = 0;
        int middle = 0;
        while (low <= high) {
            middle = (low + high) / 2;
            if (num > arr[middle]) {
                low = middle + 1;
            } else if (num < arr[middle]) {
                high = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9};
        int num = 10;
        System.out.println(getIndex(nums, num));
    }

}
