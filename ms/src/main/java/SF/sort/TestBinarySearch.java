package SF.sort;

/**
 * @ClassName TestBinarySearch
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 9/10/2019 7:58 AM
 **/
public class TestBinarySearch {

    /**
     * 循环二叉树
     *
     * @param arr 数字数组
     * @param key 要查询的数字
     * @return
     */
    public static int commonBinarySearch(int[] arr, int key) {

        int low = 0;
        int high = arr.length - 1;
        int middle = 0;

        if (arr == null || arr.length <= 0) {
            return -1;
        }
        while (low <= high) {
            middle = (low + high) / 2;
            if (arr[middle] > key) {
                high = middle - 1;
            } else if (arr[middle] < key) {
                low = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {1, 3, 5, 7, 9};
        System.out.println(commonBinarySearch(arr, 9));

    }
}
