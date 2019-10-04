package SF.sort;

/**
 * @ClassName TestBinarySearch
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 9/10/2019 7:58 AM
 **/
public class TestBinarySearch {

    public static int getIndex(int[] arr, int index) {
        if (arr == null || arr.length <= 0) {
            return -1;
        }
        int low = 0;
        int high = arr.length - 1;
        int middel = 0;
        while (low <= high) {
            middel = (low + high) / 2;
            if (arr[middel] > index) {
                high = middel - 1;
            } else if (arr[middel] < index) {
                low = middel + 1;
            } else {
                return middel;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 9};
        System.out.println(getIndex(arr, 9));
    }

}
