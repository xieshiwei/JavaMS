package io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * NIO Server
 */
public class Server implements Runnable {
    /**
     * 多路复用选择器
     */
    private Selector selector;
    /**
     * 建立读缓冲区
     */
    private ByteBuffer readBuffer = ByteBuffer.allocate(1024);
    /**
     * 建立写缓冲区
     */
    private ByteBuffer writeBuffer = ByteBuffer.allocate(1024);

    /**
     * 构造初始化
     *
     * @param port
     */
    public Server(int port) {

        try {
            this.selector = Selector.open();
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.configureBlocking(false);
            ssc.bind(new InetSocketAddress(port));
            ssc.register(this.selector, SelectionKey.OP_ACCEPT);
            System.out.println("server:" + port);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }


    private void write(SelectionKey key) {

    }

    /**
     * 读取
     *
     * @param key
     */
    private void read(SelectionKey key) {
//        try {
//            this.readBuffer.clear();
//            SocketChannel sc = (SocketChannel) key.channel();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void run() {

    }


}
