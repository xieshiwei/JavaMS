package rpc.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    /**
     * 维护一个目标对象
     */
    private Object target;

    /**
     * 构造函数
     *
     * @param object
     */
    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 给目标对象生成一个代理对象
     *
     * @return
     */
    public Object getProxyInstance() {

        /**
         * 调用处理器
         */
        InvocationHandler invocation = new InvocationHandler() {
            @Override
            /**
             * 调用方法
             * proxy：代理对象，也就是Proxy.newProxyInstance()方法返回的对象，通常我们用不上它
             * method：表示当前被调用方法的反射对象，例如save()，那么method就是save()方法的反射对象；
             * args：表示当前被调用方法的参数
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("开始事务2");
                //执行目标对象方法
                Object returnValue = method.invoke(target, args);
                System.out.println("提交事务2");
                return returnValue;
            }
        };

        /**
         * 返回指定接口的代理类的实例将方法调用分派给指定的调用处理程序。
         */
        return Proxy.newProxyInstance(
                //类加载器
                target.getClass().getClassLoader(),
                //返回的对象要实现哪些接口
                target.getClass().getInterfaces(),
                //调用处理器
                invocation);
    }

}
