package netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;


public class ServerHandler extends ChannelHandlerAdapter {


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
        //转换成ByteBuf
        ByteBuf buf = (ByteBuf) msg;
        //创建Byte数组
        byte[] data = new byte[buf.readableBytes()];
        //读取buf里的数据放到data数组中
        buf.readBytes(data);
        //data包装一下放入string，待输出
        String request = new String(data, "utf-8");
        System.out.println("Server: " + request);
    }

}
