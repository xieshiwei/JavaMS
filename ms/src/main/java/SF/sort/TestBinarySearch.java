package SF.sort;

/**
 * @ClassName TestBinarySearch
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 9/10/2019 7:58 AM
 **/
public class TestBinarySearch {

    public static int getNumber(int[] arr, int num) {
        if (arr == null || arr.length <= 0) {
            return -1;
        }

        int low = 0;
        int high = arr.length - 1;
        int middle = 0;
        while (low <= high) {
            //求中间值
            middle = (low + high) / 2;
            //如果中间值大于要查询的数字，中间值左边的数据拿来作为查询区间
            if (arr[middle] > num) {
                high = arr[middle - 1];
            } else if (arr[middle] < num) {
                low = arr[middle + 1];
            } else {
                return middle;
            }
        }
        //没有查到结果的情况
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9,};
        int num = 5;
        System.out.println("要查询的数字下标：" + getNumber(arr, num));
    }
}
