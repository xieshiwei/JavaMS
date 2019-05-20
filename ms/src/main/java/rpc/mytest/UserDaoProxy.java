package rpc.mytest;

/**
 * @ClassName UserDaoProxy
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2019/5/20 17:49
 **/
public class UserDaoProxy implements IUserDao {
    private IUserDao iUserDao;


    public UserDaoProxy(IUserDao iUserDao) {
        this.iUserDao = iUserDao;
    }

    @Override
    public void save() {
        System.out.println("事务开始");
        this.iUserDao.save();
        System.out.println("事务结束");
    }
}
