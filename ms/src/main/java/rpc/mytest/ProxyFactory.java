package rpc.mytest;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory implements MethodInterceptor {

    private Object object;

    public ProxyFactory(Object object) {
        this.object = object;
    }

    public Object getProxyInstance() {

        //工具类
        Enhancer enhancer = new Enhancer();
        //加载父类
        enhancer.setSuperclass(object.getClass());
        //回调
        enhancer.setCallback(this);
        //添加子类
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始事务");
        Object restult = method.invoke(object, objects);
        System.out.println("结束事务");
        return restult;
    }

//    public Object getProxyInstance() {
//        return Proxy.newProxyInstance(object.getClass().getClassLoader(),
//                object.getClass().getInterfaces(), new InvocationHandler() {
//                    @Override
//                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                        System.out.println("事务开始");
//                        Object resultInvoke = method.invoke(object, args);
//                        System.out.println("事务结束");
//                        return resultInvoke;
//                    }
//                });
//    }
}
