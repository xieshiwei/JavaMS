package io.aio;

import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName Server
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2019/5/11 14:19
 **/
public class Server {

    /**
     * 线程池
     */
    private ExecutorService executorService;

    /**
     * 线程组,用于接收多个Client的连接
     */
    private AsynchronousChannelGroup threadGroup;

    /**
     * 服务器通道
     */
    public AsynchronousServerSocketChannel assc;

    /***
     * 服务器处理
     * @param port 端口号
     */
    public Server(int port) {
        try {

            //创建一个线程池
            executorService = Executors.newCachedThreadPool();

            //
            /**
             * 创建线程组，把线程池作为参数传进去，创建一个线程组
             * 在AIO中客户端想去和服务器端链接，早期在NIO的时候通过selector去轮训，在AIO中把这块屏蔽掉了
             * 这些工作交给线程组去做，
             */
            threadGroup = AsynchronousChannelGroup.withCachedThreadPool(executorService, 1);
            //创建服务器通道
            assc = AsynchronousServerSocketChannel.open(threadGroup);
            //进行绑定
            assc.bind(new InetSocketAddress(port));
            System.out.println("server start,port:" + port);
            //进行阻塞
            assc.accept(this, new ServerCompletionHandler());
            //一直阻塞，不让服务器停止
            Thread.sleep(Integer.MAX_VALUE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Main
     * @param args
     */
    public static void main(String[] args) {
        Server server = new Server(8765);
    }

}
