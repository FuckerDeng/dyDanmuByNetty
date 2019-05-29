package df.client;

import df.nettyhandler.InByte2StrHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

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
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bs = new Bootstrap();
            bs.group(group)//设置事件
                    .channel(NioSocketChannel.class)//采用NIO模式
                    .remoteAddress(inetAddress,port)//连接的地址和端口
                    .handler(new ChannelInitializer<SocketChannel>() {//给channelpipile添加handler链
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new InByte2StrHandler());
                        }
                    });
            ChannelFuture f = bs.connect().sync();
            f.channel().closeFuture().sync();
        }finally {
            group.shutdownGracefully().sync();
        }
    }
}
