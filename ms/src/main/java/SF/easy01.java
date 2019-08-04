package SF;

/**
 * @ClassName easy01
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 8/3/2019 3:16 PM
 **/
public class easy01 {

    /**
     * 反转一个只有3位数的整数。
     * 你可以假设输入一定是一个只有三位数的整数，这个整数大于等于100，小于1000。
     * 样例 1:
     *
     * 输入: number = 123
     * 输出: 321
     * 样例 2:
     *
     * 输入: number = 900
     * 输出: 9
     * @param num
     */
    private static void convert3Num(int num) {

        if (num > 0 && num < 1000) {


            int firstResult = num / 100;
            int secondResult = num % 100 / 10;
            int lastResult = num % 10;

            System.out.println("输入的数字：" + num);
            System.out.println("第一个数字：" + firstResult);
            System.out.println("第二个数字：" + secondResult);
            System.out.println("第三个数字：" + lastResult);

            String result = "";
            if (lastResult != 0) {
                result += lastResult;
            }

            if (lastResult != 0 && firstResult != 0 || secondResult != 0) {
                result += secondResult;
            }

            if (firstResult != 0) {
                result += firstResult;
            }

            System.out.println(result);
        }
    }


    public static void main(String[] args) {
        convert3Num(900);
    }
}
