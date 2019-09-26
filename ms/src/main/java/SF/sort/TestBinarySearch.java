package SF.sort;

/**
 * @ClassName TestBinarySearch
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 9/10/2019 7:58 AM
 **/
public class TestBinarySearch {

    public static int getIndex(int[] arr, int num) {
        if (arr == null || arr.length <= 0) {
            return -1;
        }
        int low = 0;
        int high = arr.length - 1;
        int middle = 0;
        while (low <= high) {
            middle = (low + high) / 2;
            if (arr[middle] > num) {
                high = middle - 1;
            } else if (arr[middle] < num) {
                low = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        int num = 0;
        System.out.println(getIndex(arr, num));
    }

}
