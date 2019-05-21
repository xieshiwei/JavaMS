package rpc.mytest;

/**
 * @ClassName App
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2019/5/20 16:19
 **/
public class App {
    public static void main(String[] args) {

        IUserDao iUserDao = new UserDaoImpl();

        UserDaoProxy proxy = new UserDaoProxy(iUserDao);
        proxy.save();


    }
}
