package thread;

/**
 * @ClassName MyCopyOnWrite 多线程并发容器
 * @Author 萌琪琪爸爸
 * CopyOrWrite容器设计思想：
 * 读写分离
 * t1线程要写操作一个容器的时候，系统会将容器copy一份副本，t1线程对副本进行写操作，原容器不会改变
 * 如果此时t2,t3线程有读容器的请求的时候直接读取原容器，原容器没有修改不用加任何锁
 * 当t1操作完后，会将所有原容器的引用指向副本，最后将原容器GC回收
 * 为了解决高并发，底层使用了重入锁，不会出现数据不一致问题
 *
 * 使用场景，读多写少的时候用
 *
 *
 * @Description //TODO
 * @Date 2019/4/29 16:55
 **/
public class MyCopyOnWrite {

    public static void main(String[] args) {
        
    }
}
