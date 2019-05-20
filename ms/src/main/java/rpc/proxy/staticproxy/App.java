package rpc.proxy.staticproxy;

/**
 * 测试类
 */
public class App {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        UserDaoProxy proxy = new UserDaoProxy(userDao);
        proxy.save();
    }
}
