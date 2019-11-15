package SF.easy;

/**
 * @ClassName testEasy
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 11/14/2019 11:47 AM
 **/
public class testEasy {

    /**
     * 反转一个只有3位数的整数。
     * 你可以假设输入一定是一个只有三位数的整数，这个整数大于等于100，小于1000。
     * 样例 1:
     * 输入: number = 123
     * 输出: 321
     * 样例 2:
     * 输入: number = 900
     * 输出: 9
     **/

    /**
     * 1 判断数字是否三位数
     * 2 百/100，十%100/10，个%10
     * 3 个位，十位，百位不为0输出，十位如果为0，个位百位不为0输出十位，
     *
     * @param nums
     * @return
     */
    public static String reverese3Numbers(int nums) {
        if (nums <= 0 || nums > 999) {
            return "";
        }
        int first = nums / 100;
        int second = nums % 100 / 10;
        int last = nums % 10;
        String result = "";
        if (last != 0) {
            result += last;
        }
        if (second != 0 || first != 0 && last != 0) {
            result += second;
        }
        if (first != 0) {
            result += first;
        }
        return result;
    }

    /**
     * 将一个字符由小写字母转换为大写字母
     * 你可以假设输入一定在小写字母 a ~ z 之间
     * <p>
     * 样例 1:
     * <p>
     * 输入: 'a'
     * 输出: 'A'
     * 样例 2:
     * <p>
     * 输入: 'b'
     * 输出: 'B'
     * <p>
     * 1 判断字符串是否为空
     * 2 创建char数组，存放字符串所有字符
     * 3 循环数组，将每个字符转换与a~z,A~Z的ASCII码比较，如果在65~90,当前元素ASCII+32,97~122之间就做转换当前元素就ASCII码-32,
     **/
    public static String toggleCase(String word) {
        if (word == null || "".equals(word)) {
            return word;
        }
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!"".equals(chars[i])) {
                if (chars[i] >= 65 && chars[i] <= 90) {
                    chars[i] += 32;
                } else if (chars[i] >= 97 && chars[i] <= 122) {
                    chars[i] -= 32;
                }
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(toggleCase("abcde,ABCDE"));
    }

}
