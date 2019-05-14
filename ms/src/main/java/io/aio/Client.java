package io.aio;

import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

public class Client implements Runnable {

    /**
     * 客户端通道
     */
    private AsynchronousSocketChannel asc;

    /**
     * 构造
     *
     * @throws Exception
     */
    public Client() throws Exception {

        //打开异步套接字通道
        asc = AsynchronousSocketChannel.open();
    }

    /**
     * 连接通道
     */
    public void connect() {
        asc.connect(new InetSocketAddress("127.0.0.1", 8765));
    }

    /**
     * 将返回结果写入缓冲区
     *
     * @param response
     */
    public void write(String response) {
        try {
            asc.write(ByteBuffer.wrap(response.getBytes()));

        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    private void read() {

        //创建和分配缓存区大小
        ByteBuffer buf = ByteBuffer.allocate(1024);
        try {
            asc.read(buf).get();
            /**
             * 调换这个buffer的当前位置，并且设置当前位置是0。
             * 说的意思就是：将缓存字节数组的指针设置为数组的开始序列即数组下标0。
             * 这样就可以从buffer开头，对该buffer进行遍历（读取）了。
             */
            buf.flip();
            //返回缓冲区剩余元素数
            byte[] respByte = new byte[buf.remaining()];
            buf.get(respByte);
            System.out.println(new String(respByte, "utf-8").trim());


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void run() {

    }
}
