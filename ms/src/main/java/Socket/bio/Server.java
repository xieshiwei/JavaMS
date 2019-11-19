package Socket.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName Server
 * @Author 萌琪琪爸爸
 * 两个服务之间点对点的链接采用socket套接字通信
 *
 * Server启动后会先阻塞，等待Client发起请求
 * Client1发起请求，Server接受到请求，创建线程处理Client1的请求
 * Client2发起请求，Server接到到请求，再创建个线程处理Client2的请求
 *
 * BIO最大的问题就是不支持很多客户端发起请求，因为每次请求都会创建个线程消耗资源
 *
 *
 * @Description //TODO
 * @Date 11/19/2019 12:40 PM
 **/
public class Server {
    final static int PROT = 8765;

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(PROT);
            System.out.println("server start");
            //进行阻塞等待连接
            Socket socket = server.accept();
            //新建一个线程执行客户端的任务
            new Thread(new ServerHandler(socket)).start();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            server = null;
        }
    }
}
