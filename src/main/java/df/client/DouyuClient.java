package df.client;

import df.dyutil.MyUtil;
import df.nettyhandler.Byte2MsgStrHandler;
import df.nettyhandler.ByteToMsgDecoder;
import df.nettyhandler.MsgStrHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.epoll.EpollSocketChannel;
import io.netty.channel.nio.NioEventLoopGroup;

import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.InetAddress;


public class DouyuClient {
    private InetAddress inetAddress;
    private int port = 8601;
    public Channel channel = null;
    private Logger logger = LogManager.getLogger(DouyuClient.class);

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
                                    .addLast(new Byte2MsgStrHandler())
                                    .addLast(new MsgStrHandler());
                        }
                    });

//            switch (MyUtil.getOs()){
//                case WINDOWS:
//                    group = new NioEventLoopGroup();
//                    bs.group(group).channel(NioSocketChannel.class);
//                    break;
//                case LINUX:
//                    group = new EpollEventLoopGroup();
//                    bs.group(group).channel(EpollSocketChannel.class);
//                case UNIDENTIFIED:
//                    logger.error("无法识别的计算机系统！");
//                    System.exit(-1);
//                    break;
//            }
            group = new NioEventLoopGroup();
            bs.group(group).channel(NioSocketChannel.class);

            ChannelFuture f = bs.connect().sync();
            this.channel = f.channel();
            f.channel().closeFuture().sync();
        }finally {
            group.shutdownGracefully().sync();
        }
    }
}
