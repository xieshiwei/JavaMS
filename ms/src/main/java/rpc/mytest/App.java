package rpc.mytest;

/**
 * @ClassName App
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2019/5/20 16:19
 **/
public class App {
    public static void main(String[] args) {
        //UserDaoImpl iUserDao = new UserDaoImpl();
        //IUserDao proxy = (IUserDaoUserDao) new ProxyFactory(iUserDao).getProxyInstance();
        //ProxyFactory proxy = new ProxyFactory(iUserDao);
        //UserDaoImpl userDao = (UserDaoao) proxy.getProxyInstance();
        //userDao.save();

        IUserDao iUserDao = new UserDao();
        ProxyFactory proxy = new ProxyFactory(iUserDao);
        IUserDao result = (IUserDao) proxy.getProxyInstance();
        result.save();
    }
}
