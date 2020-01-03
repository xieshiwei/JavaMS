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
     * 将一个字符由小写字母转换为大写字母
     * 你可以假设输入一定在小写字母 a ~ z 之间
     * 样例 1:
     * 输入: 'a'
     * 输出: 'A'
     * 样例 2:
     * 输入: 'b'
     * 输出: 'B'
     **/
    public static void main(String[] args) {
        String word = "abcABC";
        System.out.println(toggleCase1(word));
        System.out.println(toggleCase2(word));
    }

    public static String toggleCase1(String words) {
        if (words == null || "".equals(words)) {
            return words;
        } else {
            char[] chars = words.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] >= 'a' && chars[i] <= 'z') {
                    //小写字母判断
                    chars[i] -= 32;
                } else if (chars[i] >= 'A' && chars[i] <= 'Z') {
                    //大写字母判断
                    chars[i] += 32;
                }
            }
            return new String(chars);
        }
    }

    public static String toggleCase2(String words) {
        if (words == null || "".equals(words)) {
            return words;
        } else {
            char[] chars = words.toCharArray();
            for (char aChar : chars) {
                if (aChar >= 'a' && aChar <= 'z') {
                    //小写字母判断
                    System.out.println(aChar);
                    aChar -= 32;
                    System.out.println(aChar);
                } else if (aChar >= 'A' && aChar <= 'Z') {
                    //大写字母判断
                    System.out.println(aChar);
                    aChar += 32;
                    System.out.println(aChar);
                }
            }
            return new String(chars);
        }

    }


}

