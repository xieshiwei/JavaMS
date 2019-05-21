package rpc.proxy.dynamicproxy;


/**
 * 接口实现
 */
public class UserDaoImpl implements IUserDao {

    @Override
    public void save() {
        System.out.println("保存数据成功");
    }
}
