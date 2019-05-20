package rpc.mytest;

/**
 * @ClassName UserDao
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2019/5/20 17:04
 **/
public class UserDao implements IUserDao {

    @Override
    public void save() {
        System.out.println("保存");
    }
}
