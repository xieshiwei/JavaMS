package io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerHandler implements Runnable {

    private Socket socket;

    /**
     * ConStructor
     *
     * @param socket
     */
    public ServerHandler(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            //创建将数据存放在缓冲区的容器
            in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            //创建输出数据的容器
            out = new PrintWriter(this.socket.getOutputStream(), true);
            String body = null;
            while (true) {
                //读取一行数据并返回，为空返回null
                body = in.readLine();
                if (body == null) {
                    break;
                }
                System.out.println("Server" + body);
                out.println("Server response");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            socket = null;
        }
    }
}
