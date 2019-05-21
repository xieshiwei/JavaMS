package io.bio;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    final static int PORT = 8765;

    public static void main(String[] args) {

        ServerSocket server = null;
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            server = new ServerSocket(PORT);
            System.out.println("server start");
            Socket socket = null;
            HandlerExecutorPool executorPool = new HandlerExecutorPool(50, 1000);
            while (true) {
                socket = server.accept();
                executorPool.executor(new ServerHandler(socket));
            }

        } catch (Exception exp) {
            exp.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception exp) {
                    exp.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (Exception exp) {
                    exp.printStackTrace();
                }
            }
            if (server != null) {
                try {
                    server.close();
                } catch (Exception exp) {
                    exp.printStackTrace();
                }
            }
        }
    }
}
