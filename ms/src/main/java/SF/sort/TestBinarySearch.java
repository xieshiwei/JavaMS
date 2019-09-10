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
        //最小位置
        int low = 0;
        //最大长度
        int high = arr.length - 1;
        //中间数
        int middle = 0;

        if (key < arr[low] || key > arr[high] || low > high) {
            return -1;
        }

        while (low <= high) {
            //二叉树中间值
            middle = (low + high) / 2;
            if (arr[middle] > key) {
                high = middle - 1;
            } else if (arr[middle] < key) {
                low = middle + 1;
            } else {
                return middle;
            }
        }
    }


}
