package df.nettyhandler;

import df.Manager.MsgManger;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class MsgStrHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        MsgManger.lastMsgTime = System.currentTimeMillis();
        MsgManger.push(s);
    }
}
