package SF.easy;

/**
 * @ClassName testEasy
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 11/14/2019 11:47 AM
 **/
public class testEasy {

    public static String Reverse3numbers(int num) {
        String result = "";
        if (num > 0 && num < 1000) {
            int first = num / 100;
            int second = num % 100 / 10;
            int last = num % 10;

            if (last != 0) {
                result += last;
            }
            if (second != 0 || first != 0 && last != 0) {
                result += second;
            }
            if (first != 0) {
                result += first;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Reverse3numbers(001));
    }
}
