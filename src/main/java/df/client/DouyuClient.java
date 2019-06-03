package df.client;

import df.dyutil.MyUtil;
import df.dyutil.OS;
import df.nettyhandler.Byte2MsgStrHandler;
import df.nettyhandler.ByteToMsgDecoder;
import df.nettyhandler.InByte2StrHandler;
import df.nettyhandler.MsgStrHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.epoll.EpollSocketChannel;
import io.netty.channel.nio.NioEventLoopGroup;

import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;

import java.net.InetAddress;


public class DouyuClient {
    private InetAddress inetAddress;
    private int port = 8601;


    {
        try {
            inetAddress = InetAddress.getByName("openbarrage.douyutv.com");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void start() throws Exception{
        EventLoopGroup group = null;

        try {
            Bootstrap bs = new Bootstrap();
            bs.remoteAddress(inetAddress,port)//连接的地址和端口
                    .handler(new ChannelInitializer<SocketChannel>() {//给channelpipile添加handler链
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline()
                                    .addLast(new ByteToMsgDecoder())
//                                    .addLast(new DelimiterBasedFrameDecoder(4*1024,Unpooled.copiedBuffer("/\0".getBytes())))
                                    .addLast(new Byte2MsgStrHandler())
                                    .addLast(new MsgStrHandler());
                        }
                    });

            switch (MyUtil.getOs()){
                case WINDOWS:
                    System.out.println("程序运行与windows系统！");
                    group = new NioEventLoopGroup();
                    bs.group(group).channel(NioSocketChannel.class);
                    break;
                case LINUX:
                    System.out.println("程序运行与linux系统！");
                    group = new EpollEventLoopGroup();
                    bs.group(group).channel(EpollSocketChannel.class);
                case UNIDENTIFIED:
                    System.out.println("无法识别的计算机系统！");
                    break;
            }

            ChannelFuture f = bs.connect().sync();
            f.channel().closeFuture().sync();
        }finally {
            group.shutdownGracefully().sync();
        }
    }
}
