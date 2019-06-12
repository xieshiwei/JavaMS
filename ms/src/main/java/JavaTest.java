/**
 * @ClassName JavaTest
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2019/5/30 12:36
 **/
public class JavaTest {

    public static void main(String[] args) {

        String name1 = new String("abc");
        String name2 = new String("abc");

        equalsByString(name1, name2);

//        String temp = "abcde";
//        int code = temp.hashCode();
//        System.out.println(code);

//        Object obj = new Object();
//        obj.equals();
//        obj.hashCode();
//        obj.toString();
//        obj.getClass();
//        obj.notify();
//        obj.notifyAll();
//        obj.wait();
    }

    private static void testEquals(Object name1, Object name2) {

        if (name1.equals(name2)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    private static void equalsByString(String name1, String name2) {

        if (name1.equals(name2)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

}
