package netty.helloworld;


import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;

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

        try {
            ByteBuf buf = (ByteBuf) msg;
            //buf.readableBytes() 获取buf的可读字节数
            byte[] bytes = new byte[buf.readableBytes()];
            buf.readBytes(bytes);

            String body = new String(bytes, "utf-8");
            System.out.println("Client:" + body);
        } finally {
            /**
             * ReferenceCountUtil.release()其实是ByteBuf.release()方法
             * （从ReferenceCounted接口继承而来）的包装。
             * netty4中的ByteBuf使用了引用计数（netty4实现了一个可选的ByteBuf池），
             * 每一个新分配的ByteBuf的引用计数值为1，
             * 每对这个ByteBuf对象增加一个引用，需要调用ByteBuf.retain()方法，
             * 而每减少一个引用，需要调用ByteBuf.release()方法。
             * 当这个ByteBuf对象的引用计数值为0时，表示此对象可回收。
             */
            ReferenceCountUtil.release(msg);
        }
    }
}
