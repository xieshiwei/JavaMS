package com.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName NIOServer
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2019/12/15 17:07
 **/
public class NIOServer {
    public static void main(String[] args) throws IOException {

//        //创建ServerSocketChannel 等同于 BIO的ServerSocket
//        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
//
//        //得到一个Selector对象
//        Selector selector = Selector.open();
//
//        //绑定一个端口6666，在服务器端
//        serverSocketChannel.socket().bind(new InetSocketAddress(6666));
//
//        //设置为非阻塞
//        serverSocketChannel.configureBlocking(false);
//
//        //把 serverSocketChannel 注册到 selector 关心 事件为OP_ACCEPT
//        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
//
//        //循环等待客户端连接
//        while (true) {
//            //等待一秒，如果没有事件发生，返回
//            if (selector.select(1000) == 0) {
//                //没有事件发生
//                System.out.println("服务器等待1秒，无连接");
//                continue;
//            }
//        }
//
//        //如果返回的>0，就获取到相关的selectionkey集合
//        //1，如果返回>0，就获取到相关的selectionkey集合
//        //2，selector.selectedkeys() 返回相关事件的集合
//        // 通过selectionkeys反向获取通道
//        Set<SelectionKey> selectionKeys = selector.selectedKeys();
//
//        //遍历Set<SelectionKey>，使用迭代器遍历
//        Iterator<SelectionKey> keyIterator = selectionKeys.iterator();


    }
}
