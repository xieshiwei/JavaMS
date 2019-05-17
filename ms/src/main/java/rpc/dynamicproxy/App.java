package rpc.dynamicproxy;

/**
 * 创建动态代理对象
 * 动态代理不需要实现接口,但是需要指定接口类型
 * 代理对象不需要实现接口,但是目标对象一定要实现接口,否则不能用动态代理
 */
public class App {
    public static void main(String[] args) {
        /**
         * 目标对象
         */
        IUserDao target = new UserDao();
        /**
         * 【原始的类型 class cn.itcast.b_dynamic.UserDao】
         */
        System.out.println(target.getClass());

        /**
         * 给目标对象，创建代理对象
         */
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        /**
         * class $Proxy0   内存中动态生成的代理对象
         */

        System.out.println("输出proxy信息：" + proxy.getClass());

        /**
         * 执行方法   【代理对象】
         */
        System.out.println("准备开始执行保存方法");
        proxy.save();
    }
}
