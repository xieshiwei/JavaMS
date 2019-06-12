package basic;

import sun.rmi.runtime.Log;

/**
 * @ClassName EqualTest
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2019/6/4 7:20
 **/
public class EqualTest {

    /**
     * java中的==是比较两个对象在JVM中的地址
     *
     * @param args
     */
    public static void main(String[] args) {

        //等号
        denghao();
        //equals
        equalsByString();

        //hashcode
        hashCodeTest();
    }

    /**
     * java中的==是比较两个对象在JVM中的地址
     */
    private static void denghao() {
        System.out.println("=========== == ==========");
        String s1 = "nihao";
        String s2 = "nihao";
        String s3 = new String("nihao");
        //==比较的是JVM中的地址
        System.out.println(s1 == s2);
        //是因为通过new产生的对象在堆中，s3是堆中变量的引用，而是s1是指向字符串字面值"nihao"的引用，地址不同所以不相等。
        System.out.println(s1 == s3);
    }

    /**
     * String类中的equals首先比较地址，如果是同一个对象的引用，可知对象相等，返回true。
     * 若果不是同一个对象，equals方法挨个比较两个字符串对象内的字符，只有完全相等才返回true，否则返回false。
     */
    private static void equalsByString() {
        System.out.println("=========== equals ==========");
        String s1 = "nihao";
        String s2 = "nihao";
        String s3 = new String("nihao");
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
    }

    /**
     * hashCode是根类Obeject中的方法。
     * 默认情况下，Object中的hashCode() 返回对象的32位jvm内存地址。
     * 也就是说如果对象不重写该方法，则返回相应对象的32为JVM内存地址。
     * <p>
     * 下面例子中Cat没有重写hashCode方法的类，直接返回32位对象在JVM中的地址；
     * Long类重写了hashCode方法，返回计算出的hashCode数值：
     */
    private static void hashCodeTest() {
        System.out.println("=========== String hashCode ==========");
        String s11 = new String("1");
        String s12 = new String("1");
        System.out.println("s11 hashcode:" + s11.hashCode());
        System.out.println("s12 hashcode:" + s12.hashCode());

        Cat s1 = new Cat("1", "1");
        Cat s2 = new Cat("1", "1");
        System.out.println("s1 hashcode:" + s1.hashCode());
        System.out.println("s2 hashcode:" + s2.hashCode());
        System.out.println("=========== Long hashCode ==========");
        Long num1 = new Long(8);
        Long num2 = new Long(8);
        System.out.println("s1 hashcode:" + num1.hashCode());
        System.out.println("s2 hashcode:" + num2.hashCode());

    }
}
