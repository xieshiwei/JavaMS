package thread.mysynchronized.demo5.syncdubbo1;

/**
 * @ClassName ThreadSyncDubbo1
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2019/5/29 13:24
 **/
public class ThreadSyncDubbo1 extends Thread {

    /**
     * syncDubbo1
     */
    SyncDubbo1 syncDubbo1 = null;

    /**
     * Constructor
     *
     * @param syncDubbo1
     */
    public ThreadSyncDubbo1(SyncDubbo1 syncDubbo1) {
        this.syncDubbo1 = syncDubbo1;
    }

    @Override
    public void run() {
        this.syncDubbo1.method1();
    }
}
