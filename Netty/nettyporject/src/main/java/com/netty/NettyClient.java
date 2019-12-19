package com.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @ClassName NettyClient
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2019/12/18 21:43
 **/
public class NettyClient {


    public static void main(String[] args) {
        //客户端需要一个事件循环组
        EventLoopGroup eventExecutors = new NioEventLoopGroup();

        //创建客户端启动对象
        Bootstrap bootstrap = new Bootstrap();

        //对客户端启动项进行设置
        bootstrap.group(eventExecutors)
                //设置客户端通道的实现类（反射）
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        //加入自己的处理器
                        ch.pipeline().addLast(null);
                    }
                });
        //

    }
}
