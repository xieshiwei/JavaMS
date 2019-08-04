package SF;

/**
 * @ClassName easy02
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 8/4/2019 12:13 AM
 **/
public class easy02 {

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
     *
     * @param word
     */
    private static void convertChat(char word) {
        if (!"".equals(word)) {

            int ascIICode = 0;
            ascIICode = (byte) word;
            if (ascIICode >= 65 && ascIICode <= 90) {
                ascIICode -= 32;
                char aa = (char) ascIICode;
                System.out.println(aa);
            } else {
                ascIICode += 32;
                char aa = (char) ascIICode;
                System.out.println(aa);
            }

        }
    }

    public static void main(String[] args) {
        convertChat('a');
    }


}
