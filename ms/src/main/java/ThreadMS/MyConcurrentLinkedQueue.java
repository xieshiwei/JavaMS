package ThreadMS;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @ClassName MyConcurrentLinkedQueue
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

        //从头部去除元素，并从队列里删除
        System.out.println(queue.poll());

        System.out.println(queue.size());
        System.out.println(queue.peek());
        System.out.println(queue.size());
    }
}
