package netty.helloworld;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class Server {
    public static void main(String[] args) throws Exception {
        //1.第一个线程组用于接收Client的连接
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //2.第二个线程组用于实际业务处理操作
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        //3.创建一个辅助类BootStarp，对Server进行一系列的配置
        ServerBootstrap b = new ServerBootstrap();
        //把两个线程组加入到辅助类中
        b.group(bossGroup, workerGroup)
                //指定通道类型
                .channel(NioServerSocketChannel.class)
                //一定要使用ChindHandler来绑定事件处理器
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new ServerHandler());
                    }
                })
                //设置TCP的缓冲区
                .option(ChannelOption.SO_BACKLOG, 128)
                //保持连接
                .option(ChannelOption.SO_KEEPALIVE, true);

        //绑定指定的端口进行监听
        ChannelFuture f = b.bind(8765).sync(); // (7)

        f.channel().closeFuture().sync();
        workerGroup.shutdownGracefully();
        bossGroup.shutdownGracefully();

    }
}
