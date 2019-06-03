package df.nettyhandler;

import df.dyutil.DouYuUtils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.CharsetUtil;

import java.util.List;

public class Byte2MsgStrHandler extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
//        System.out.println(byteBuf.toString(CharsetUtil.UTF_8));
//        byteBuf.writeCharSequence("/",CharsetUtil.UTF_8);
        //将消息字节转换为字符串
        byte[] msgBytes = DouYuUtils.readMsg(byteBuf);
        if(msgBytes!=null){
            String result = new String(msgBytes,"utf-8");
            System.out.println(result);
            list.add(result);
        }
        byteBuf.clear();

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("连接已准备就绪，发送数据！");
        System.out.println("channelActive");
        //登录斗鱼弹幕服务器
        DouYuUtils.connectDouyuDanmu(4615502,ctx);


        //加入弹幕房间分组-999
        DouYuUtils.joinDanmuGroup(4615502,ctx);
//        super.channelActive(ctx);
    }
}
