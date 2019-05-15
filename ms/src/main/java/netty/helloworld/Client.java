package netty.helloworld;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class Client {

    public static void main(String[] args) throws Exception {
        //
        EventLoopGroup group = new NioEventLoopGroup();

        //3.创建一个辅助类BootStarp，对Server进行一系列的配置
        Bootstrap b = new Bootstrap();
        //把两个线程组加入到辅助类中
        b.group(group)
                //指定通道类型
                .channel(NioSocketChannel.class)
                //一定要使用ChindHandler来绑定事件处理器
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new ClientHander());
                    }
                });

        //绑定指定的端口进行监听
        ChannelFuture f = b.connect("127.0.0.1", 8765).sync();
        //发送消息
        Thread.sleep(1000);
        f.channel().writeAndFlush(Unpooled.copiedBuffer("777".getBytes()));
        f.channel().writeAndFlush(Unpooled.copiedBuffer("666".getBytes()));
        Thread.sleep(2000);
        f.channel().writeAndFlush(Unpooled.copiedBuffer("888".getBytes()));
        f.channel().flush();
        f.channel().closeFuture().sync();
        group.shutdownGracefully();
    }
}
