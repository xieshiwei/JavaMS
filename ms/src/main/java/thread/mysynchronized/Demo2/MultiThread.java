package thread.mysynchronized.Demo2;

/**
 * @ClassName MultiThread
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2019/5/29 0:57
 **/
public class MultiThread extends Thread {

    /**
     * ThreadDemo2
     */
    ThreadDemo2 t = null;
    /**
     * tag
     */
    String tag = null;

    /**
     * Constructor
     *
     * @param t
     */
    public MultiThread(ThreadDemo2 t, String tag) {
        this.t = t;
        this.tag = tag;
    }

    /**
     * 调用输出方法
     */
    @Override
    public void run() {
        t.printNum(tag);
    }
}
