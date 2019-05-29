package thread.mysynchronized.demo5.syncdubbo2;

/**
 * @ClassName SyncDubbo2
 * @Author 萌琪琪爸爸
 * @Description 继承关系的锁重入
 * @Date 2019/5/29 13:31
 **/
public class SyncDubbo2 {

    public static void main(String[] args) {
        SubFun sub = new SubFun();
        ThreadSyncDubbo2 t = new ThreadSyncDubbo2(sub);
        t.start();
    }
}
