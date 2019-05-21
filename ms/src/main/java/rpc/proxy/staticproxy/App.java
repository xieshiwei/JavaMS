package rpc.proxy.staticproxy;

/**
 * 测试类
 */
public class App {
    public static void main(String[] args) {
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        UserDaoProxy proxy = new UserDaoProxy(userDaoImpl);
        proxy.save();
    }
}
