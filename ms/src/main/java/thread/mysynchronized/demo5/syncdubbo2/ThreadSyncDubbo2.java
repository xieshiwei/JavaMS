package thread.mysynchronized.demo5.syncdubbo2;

/**
 * @ClassName ThreadSyncDubbo2
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2019/5/29 14:02
 **/
public class ThreadSyncDubbo2 extends Thread {

    SubFun subFun = null;

    /**
     * Constructor
     *
     * @param subFun
     */
    public ThreadSyncDubbo2(SubFun subFun) {
        this.subFun = subFun;
    }

    @Override
    public void run() {
        subFun.operationSub();
    }
}
