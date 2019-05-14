package io.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;

/**
 * @ClassName ServerCompletionHandler
 * @Author 萌琪琪爸爸
 * @Description //TODOAsynchronousSocketChannel
 * @Date 2019/5/11 15:12
 **/
public class ServerCompletionHandler implements CompletionHandler<AsynchronousSocketChannel, Server> {


    /**
     * 连接成功后的处理
     *
     * @param result     服务器通道
     * @param attachment Server类
     */
    @Override
    public void completed(AsynchronousSocketChannel result, Server attachment) {
        //当有下一个客户端接入的时候直接调用Server的accept方法，这样反复执行下去，保证多个客户端可以阻塞
        attachment.assc.accept(attachment, this);
        read(result);
    }

    /**
     * 读取数据
     *
     * @param asc socket通道
     */
    private void read(final AsynchronousSocketChannel asc) {
        //读取数据
        ByteBuffer buf = ByteBuffer.allocate(1024);
        asc.read(buf, buf, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer resultSize, ByteBuffer attachment) {
                //进行读取之后，重置标识位
                attachment.flip();
                //获得读取的字节数
                System.out.println("Server -> " + "收到的客户端数据长度为：" + resultSize);
                //获取读取的数据
                String resultData = new String(attachment.array()).trim();
                System.out.println("Server -> " + "收到的客户端数据长度为：" + resultData);
                String response = "服务器响应, 收到了客户端发来的数据: " + resultData;
                write(asc, response);
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                exc.printStackTrace();
            }
        });
    }

    /**
     * @param asc
     * @param response
     */
    private void write(AsynchronousSocketChannel asc, String response) {
        try {
            ByteBuffer buf = ByteBuffer.allocate(1024);
            buf.put(response.getBytes());
            buf.flip();
            asc.write(buf).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    /**
     * 连接失败后的处理
     *
     * @param exc
     * @param attachment
     */
    @Override
    public void failed(Throwable exc, Server attachment) {
        exc.printStackTrace();
    }
}
