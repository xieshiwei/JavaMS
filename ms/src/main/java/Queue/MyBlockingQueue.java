package Queue;

import ThreadMS.TaskModel;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @ClassName 阻塞队列
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2019/4/29 18:50
 **/
public class MyBlockingQueue {

    /**
     * @return java.util.concurrent.ArrayBlockingQueue<java.lang.String>
     * @Author 萌琪琪爸爸
     * @Description ArrayBlockingQueue
     * 基于数组的阻塞队列,在内部维护了一个定长的数组,以便缓存队列中的数据对象,长度是需要定义的,是一个有界队列
     * @Date 2019/4/29 21:25
     * @Param []
     **/
    public ArrayBlockingQueue<String> getArrayBlockingQueue() throws InterruptedException {
        ArrayBlockingQueue<String> array = new ArrayBlockingQueue<>(5);
        array.put("a");
        array.put("b");
        array.put("c");
        array.put("d");
        array.put("e");
        array.put("f");
        return array;
    }

    /**
     * @return java.util.concurrent.LinkedBlockingQueue<java.lang.String>
     * @Author 萌琪琪爸爸
     * @Description 基于链表的阻塞队列, 内部维持着一个数据缓冲队列, 是一个无界队列
     * @Date 2019/4/29 21:30
     * @Param []
     **/
    public LinkedBlockingQueue<String> getLinkedBlockingQueue() {
        LinkedBlockingQueue<String> link = new LinkedBlockingQueue<>();
        link.offer("a");
        link.offer("b");
        link.offer("c");
        link.offer("d");
        link.offer("e");
        link.offer("f");
        return link;
    }

    /**
     * @return java.util.concurrent.SynchronousQueue<java.lang.String>
     * @Author 萌琪琪爸爸
     * @Description 是一个没有缓存的队列, 生产者的数据直接被消费者获取并消费
     * @Date 2019/4/29 21:39
     * @Param []
     **/
    public SynchronousQueue<String> getSynchronousQueue() throws InterruptedException {
        SynchronousQueue<String> syn = new SynchronousQueue<>();
        syn.put("a");
        return syn;
    }

    /**
     * 有优先级的消息队列
     *
     * @return
     */
    public PriorityBlockingQueue<TaskModel> getPriorityBlockingQueue() {
        PriorityBlockingQueue<TaskModel> q = new PriorityBlockingQueue<TaskModel>();

        TaskModel t1 = new TaskModel();
        t1.setId(3);
        t1.setName("任务1");

        TaskModel t2 = new TaskModel();
        t2.setId(6);
        t2.setName("任务2");

        TaskModel t3 = new TaskModel();
        t3.setId(1);
        t3.setName("任务3");

        q.add(t1);
        q.add(t2);
        q.add(t3);

        return q;
    }

    public static void main(String[] args) {
        MyBlockingQueue q = new MyBlockingQueue();
        PriorityBlockingQueue<TaskModel> priority = q.getPriorityBlockingQueue();
        System.out.println(priority);
        //getPriorityBlockingQueue();
    }


}
