package thread.mysynchronized.Demo3;

/**
 * @ClassName ThreadMethod
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2019/5/29 1:23
 **/
public class ThreadMethod extends Thread {

    /**
     * ThreadDemo3
     */
    private ThreadDemo3 threadDemo = null;

    /**
     * final Flag a:method1，b:method2
     */
    private final String TAG = "a";

    /**
     * Flag a:method1，b:method2
     */
    private String tag = "";

    /**
     * Constructor
     *
     * @param threadDemo
     */
    public ThreadMethod(ThreadDemo3 threadDemo, String tag) {
        this.threadDemo = threadDemo;
        this.tag = tag;
    }

    @Override
    public void run() {
        if (TAG.equals(this.tag)) {
            this.threadDemo.method1();
        } else {
            this.threadDemo.method2();
        }
    }
}
