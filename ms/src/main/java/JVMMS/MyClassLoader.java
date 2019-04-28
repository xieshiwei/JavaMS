package JVMMS;

/**
 * 1.生成int类型变量a=0
 * 2.执行静态代码段,a=1
 * 3.static int a=10
 */
public class MyClassLoader {

    static {
        System.out.println("static");
        a = 1;
    }

    //第二部分
    public static int a = 10;

    public static void main(String[] args) {
        System.out.println("ClassLoader test");
        MyClassLoader myClassLoader = new MyClassLoader();
        System.out.println(a);
    }


}
