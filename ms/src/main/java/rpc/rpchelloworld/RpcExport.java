package rpc.rpchelloworld;

import sun.reflect.annotation.ExceptionProxy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

public class RpcExport {
    private static int port = 1234;

    public static void export(final Object service) throws Exception  {
        System.out.println("Export service " + service.getClass().getName() + " on port " + port);

        // 创建socket，开始监听
        ServerSocket server = new ServerSocket(port);
        while (true) {
            final Socket socket = server.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    ObjectInputStream input = null;
                    ObjectOutputStream output = null;
                    try {
                        input = new ObjectInputStream(socket.getInputStream());
                        String methodName = input.readUTF();
                        Class<?>[] parameterTypes = (Class<?>[]) input.readObject();
                        Object[] arguments = (Object[]) input.readObject();
                        output = new ObjectOutputStream(socket.getOutputStream());
                        Method method = service.getClass().getMethod(methodName, parameterTypes);
                        Object result = method.invoke(service, arguments);
                        output.writeObject(result);
                    } catch (Exception exp) {

                    } finally {
                        try {
                            if (output != null) {
                                output.close();
                            }
                            if (input != null) {
                                input.close();
                            }
                            socket.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }
}
