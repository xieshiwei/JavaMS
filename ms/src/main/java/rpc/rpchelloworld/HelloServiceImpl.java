package rpc.rpchelloworld;

public class HelloServiceImpl implements HelloService {

    /**
     * 接口实现
     *
     * @param name
     * @return
     */
    @Override
    public String sayHello(String name) {
        return "Hello" + name;
    }
}
