package io.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class Server implements Runnable {


    private Selector selector;


    private ByteBuffer readBuffer = ByteBuffer.allocate(1024);
    private ByteBuffer writeBuffer = ByteBuffer.allocate(1024);

    /**
     * 构造初始化
     *
     * @param port
     */
    public Server(int port) {

        try {
            this.selector = Selector.isOpen();
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.configureBlocking(false);
            ssc.bind(new InetSocketAddress(port));
            ssc.register(this.selector, SelectionKey.OP_ACCEPT);
            System.out.println("server:" + port);

        } catch (Exception exp) {
            exp.printStackTrace();
        }

    }

    @Override
    public void run() {

    }
}
