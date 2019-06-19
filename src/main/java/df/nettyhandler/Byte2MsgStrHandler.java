package df.nettyhandler;

import df.dyutil.Config;
import df.dyutil.DouYuUtils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.CharsetUtil;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Byte2MsgStrHandler extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
//        System.out.println(byteBuf.toString(CharsetUtil.UTF_8));
//        byteBuf.writeCharSequence("/",CharsetUtil.UTF_8);
        //将消息字节转换为字符串
        byte[] msgBytes = DouYuUtils.readMsg(byteBuf);
        if(msgBytes!=null){
            String result = new String(msgBytes,"utf-8");
            list.add(result);
        }
//        byteBuf.clear();

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        //登录斗鱼弹幕服务器
        DouYuUtils.connectDouyuDanmu(Config.roomId,ctx);


        //加入弹幕房间分组-999
        DouYuUtils.joinDanmuGroup(Config.roomId,ctx);
//        super.channelActive(ctx);

        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(new HeartTask(ctx.channel()),44,45, TimeUnit.SECONDS);

    }
}
