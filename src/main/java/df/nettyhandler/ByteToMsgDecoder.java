package df.nettyhandler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

import java.nio.ByteOrder;

public class ByteToMsgDecoder extends LengthFieldBasedFrameDecoder {
    public ByteToMsgDecoder(){
        super(ByteOrder.LITTLE_ENDIAN,Integer.MAX_VALUE,0,4,0,0,true);
    }
    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        return super.decode(ctx, in);
    }
}
