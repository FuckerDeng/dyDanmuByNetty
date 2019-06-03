package df.nettyhandler;


import df.dyutil.DouYuUtils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class InByte2StrHandler extends SimpleChannelInboundHandler<ByteBuf> {
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("读取动作完成！");
        super.channelReadComplete(ctx);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf o) throws Exception {
        System.out.println("接收到消息！");
        ByteBuf byteBuf = (ByteBuf) o;
        byte[] msgBytes = DouYuUtils.readMsg(byteBuf);
        if(msgBytes!=null){
            System.out.println(new String(msgBytes,"utf-8"));
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelActive");
        //登录斗鱼弹幕服务器
        DouYuUtils.connectDouyuDanmu(1761021,ctx);


        //加入弹幕房间分组-999
        DouYuUtils.joinDanmuGroup(1761021,ctx);
//        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelInActive");
        super.channelInactive(ctx);
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerAdded");
        super.handlerAdded(ctx);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerRemoved");
        super.handlerRemoved(ctx);
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel registered");
        super.channelRegistered(ctx);
    }



    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("channel exceptionCaught");
        cause.printStackTrace();
        super.exceptionCaught(ctx, cause);
    }
}
