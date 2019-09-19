package SF.sort;

/**
 * @ClassName TestBinarySearch
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 9/10/2019 7:58 AM
 **/
public class TestBinarySearch {

    public static int getBinarySearchResult(int[] arr, int num) {

        int low = 0;
        int high = 0;
        int middle = 0;

        if (arr == null || arr.length <= 0) {
            return -1;
        }

        high = arr.length - 1;

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
        System.out.println("下标：" + getBinarySearchResult(arr, 9));
    }


}
