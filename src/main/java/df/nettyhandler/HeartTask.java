package df.nettyhandler;

import df.Manager.MsgManger;
import df.dyutil.DouYuUtils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;

public class HeartTask implements Runnable {
    Channel channel;
    public HeartTask(Channel channel){
        this.channel  = channel;
    }
    @Override
    public void run() {
        String heartApi = "type@=mrkl/ ";
        byte[] heartByte = DouYuUtils.sendData(heartApi);
        ByteBuf byteBuf = Unpooled.copiedBuffer(heartByte);
        this.channel.writeAndFlush(byteBuf);
        System.out.println("已发送心跳包!");

        //检查下最后一次获取消息的时间是否超过5分钟
        long now = System.currentTimeMillis();
        long goneTime = now-MsgManger.lastMsgTime;
        if(MsgManger.lastMsgTime !=0 && goneTime>5*60*100 ){
            System.out.printf("超过%d分钟未收到任何消息了。。。\n",goneTime/1000/60);
        }
    }
}
