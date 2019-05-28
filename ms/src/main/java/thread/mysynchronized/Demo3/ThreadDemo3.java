package thread.mysynchronized.Demo3;

/**
 * @ClassName ThreadDemo3
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2019/5/29 1:19
 **/
public class ThreadDemo3 {

    /**
     * 方法1,
     * 打印线程名称，休眠4秒
     */
    public void method1() {
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 方法2
     * 打印线程名称
     */
    public void method2() {
        System.out.println(Thread.currentThread().getName());
    }

    /**
     * 输出
     * a:输出方法1
     * b:输出方法2
     */
    public static void print() {
        ThreadDemo3 method = new ThreadDemo3();
        ThreadMethod t1 = new ThreadMethod(method, "a");
        ThreadMethod t2 = new ThreadMethod(method, "b");
        t1.start();
        t2.start();
    }
}
