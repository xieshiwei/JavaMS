package netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class ClientHander extends ChannelHandlerAdapter {

    /**
     * 异常时处理
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //引发异常断开连接
        cause.printStackTrace();
        ctx.close();

    }

    /**
     * 请求成功的处理
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //丢弃接收到的数据
        ((ByteBuf) msg).release();
    }
}
