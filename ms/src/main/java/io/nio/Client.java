package io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {

    public static void main(String[] args) {

        /**
         * 创建连接的地址
         */
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 8765);

        /**
         * 连接通道
         */
        SocketChannel sc = null;

        /**
         * 缓冲区
         */
        ByteBuffer buf = ByteBuffer.allocate(1024);

        try {
            //打开通道
            sc = SocketChannel.open();

            //连接
            sc.connect(address);
            while (true) {
                byte[] bytes = new byte[1024];
                System.in.read(bytes);
                buf.put(bytes);
                buf.flip();
                sc.write(buf);
                buf.clear();
            }
        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            if (sc != null) {
                try {
                    sc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
