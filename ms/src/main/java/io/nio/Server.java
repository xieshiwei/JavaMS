package io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

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
            //1 打开多路复用器
            this.selector = Selector.open();
            //2 打开服务器通道
            ServerSocketChannel ssc = ServerSocketChannel.open();
            //3 设置服务器通道为非阻塞
            ssc.configureBlocking(false);
            //4 绑定地址
            ssc.bind(new InetSocketAddress(port));
            //5 将服务器通道注册到多路复用器中，监听阻塞的事件
            ssc.register(this.selector, SelectionKey.OP_ACCEPT);
            System.out.println("Server start port:" + port);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }


    /**
     * 通道为写状态时的处理
     *
     * @param key
     */
    private void write(SelectionKey key) {
        try {
            //1 获取之前注册的socket通道对象
            ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
            //2 通道注册到多路复用选择器中，指定状态为写操作
            ssc.register(this.selector, SelectionKey.OP_WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通道为读状态时处理
     *
     * @param key
     */
    private void read(SelectionKey key) {
        try {
            //1 清空缓冲区中旧的数据
            this.readBuffer.clear();
            //2 获取之前注册的socket通道对象
            SocketChannel sc = (SocketChannel) key.channel();
            //3 读数据
            int count = sc.read(this.readBuffer);
            //4 没有数据关闭通道，关闭SelectionKey
            if (count == -1) {
                key.channel().close();
                key.cancel();
                return;
            }
            //5 有数据把position和limit复位
            this.readBuffer.flip();
            //6 根据缓冲区的可用数据长度创建byte数组
            byte[] bytes = new byte[this.readBuffer.remaining()];
            //7 bytes接受缓冲区的数据
            this.readBuffer.get(bytes);
            //8 打印
            String body = new String(bytes).trim();
            System.out.println("Server:" + body);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通道为阻塞状态时处理
     *
     * @param key
     */
    private void accept(SelectionKey key) {
        try {
            //1 获取之前注册的socket通道对象
            ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
            //2 执行阻塞方法
            SocketChannel sc = ssc.accept();
            //3 设置阻塞模式为非阻塞
            sc.configureBlocking(false);
            //4 当前通道注册到多路复用器，并设置为读的状态
            sc.register(this.selector, SelectionKey.OP_READ);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     */
    @Override
    public void run() {
        while (true) {
            try {
                //1 多路复用器监听
                this.selector.select();
                //2 返回多路复用器序已经选择的结果集
                Iterator<SelectionKey> keys = this.selector.selectedKeys().iterator();
                //3 遍历
                while (keys.hasNext()) {
                    //4 获取下一个选择的元素
                    SelectionKey key = keys.next();
                    //5 从容器中删除
                    keys.remove();
                    //6 如果是有效的
                    if (key.isValid()) {
                        //7 阻塞状态
                        if (key.isAcceptable()) {
                            this.accept(key);
                        }
                        //8 可读状态
                        if (key.isReadable()) {
                            this.read(key);
                        }
                        //9 写状态
                        if (key.isWritable()) {
                            this.write(key);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new Thread(new Server(8765)).start();
    }


}
