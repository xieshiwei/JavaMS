package SF.sort;

/**
 * @ClassName TestBinarySearch
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 9/10/2019 7:58 AM
 **/
public class TestBinarySearch {

    private static int getIndex(int[] arr, int key) {

        if (arr == null || arr.length <= 0) {
            return -1;
        }

        int low = 0;
        int high = arr.length - 1;
        int middle = 0;
        while (low < high) {
            middle = (low + high) / 2;
            if (low < high && arr[middle] > key) {
                high = middle;
            } else if (low < high && arr[middle] < key) {
                low = middle;
            } else {
                return middle;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        System.out.println(getIndex(arr, 7));
    }

}
