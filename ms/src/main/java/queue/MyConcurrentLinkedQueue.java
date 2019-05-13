package queue;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @ClassName 非阻塞队列
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2019/4/29 18:48
 **/
public class MyConcurrentLinkedQueue {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue();
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        queue.offer("e");

        //从头部开始取一个元素，并从队列里删除
        System.out.println(queue.poll());

        System.out.println(queue.size());
        //从头部开始取一个元素，不移除当前数据
        System.out.println(queue.peek());
//        System.out.println(queue.size());
    }
}
