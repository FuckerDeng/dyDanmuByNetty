package df.dyutil;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;


public class DouYuUtils {
    /**
     * 登录斗鱼弹幕服务器
     * @param roomId
     * @param ctx
     */
    public static void connectDouyuDanmu(int roomId, ChannelHandlerContext ctx) {
        String loginApi = String.format("type@=loginreq/roomid@=%d/",roomId);
        System.out.println(loginApi);
        byte[] resultData =sendData(loginApi);
        if(resultData == null){
            System.out.println("发送数据编码失败！");
            return;
        }
        ByteBuf resultBuffer = Unpooled.wrappedBuffer(resultData);
        ctx.writeAndFlush(resultBuffer);
//        resultBuffer.release();

        System.out.println("发送登陆验证消息成功！");

    }

    public static void joinDanmuGroup( int roomId,ChannelHandlerContext ctx){
        //加入-9999海量弹幕分组接受弹幕
        String joinDanmuGroupApi = String.format("type@=joingroup/rid@=%d/gid@=-9999/", roomId);
        byte[] joinByte = DouYuUtils.sendData(joinDanmuGroupApi);
        ByteBuf joinBuffer = Unpooled.wrappedBuffer(joinByte);
        ctx.writeAndFlush(joinBuffer);
//        joinBuffer.release();
        System.out.println("加入分组成功!");
    }

    /**
     * 将API请求字符串转换为字节数组
     * @param APIStr
     * @return
     */
    public static byte[] sendData(String APIStr) {
        try {
            int allLength = 4 + 4 + APIStr.length() +1;
            byte[] lengthByte = toLittleInt(allLength);
            byte[] msgType = toLittleInt(689);
            //编辑器默认项目是GBK编码，协议要的是utf-8
            byte[] data = APIStr.getBytes("ISO-8859-1");

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            outputStream.write(lengthByte);
            outputStream.write(lengthByte);
            outputStream.write(msgType);
            outputStream.write(data);
            int end = 0;
            outputStream.write(end);
            byte[] resultData = outputStream.toByteArray();
            return resultData;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 斗鱼API协议中整数用小端整数，而java中是大端整数，需要转换
     * @param allLength 数据包长度
     * @return
     */
    public static byte[] toLittleInt(int allLength) {
        byte[] result = new byte[4];
        result[0] = (byte)(allLength & 0xff);
        result[1] = (byte)(allLength>>8 & 0xff);
        result[2] = (byte)(allLength>>16 & 0xff);
        result[3] = (byte)(allLength>>24 & 0xff);
        return result;
    }

    /**
     * 协议组成：4字节的长度+ 4字节的长度（和第一个长度一样）+ 4字节的消息类型+ 实际数据 + 1字节结束符'\0'
     * @param msgBuffer
     */
    public static  byte[] readMsg(ByteBuf msgBuffer){
        byte[] msgByte = null;
        try {
            //获得第一个长度
            byte[] dataLen1 = readFromStream(msgBuffer,0,4);
            int packageDataLen1 = bytes2bigInt(dataLen1,0);
//            System.out.println("数据长度为："+packageDataLen1);
            if(packageDataLen1>=2048){
                System.out.println("解析出数据长度异常！");
                System.out.println(msgBuffer.toString(Charset.defaultCharset()));
            }
            //获得第二个长度
            byte[] dataLen2 = readFromStream(msgBuffer,0,4);
            int packageDataLen2 = bytes2bigInt(dataLen2,0);

            //获取消息类型
            byte[] msgTypebyte = readFromStream(msgBuffer,0,4);
            int msgType = bytes2bigInt(msgTypebyte,0);
//            System.out.println("消息类型为："+msgType);

            //获取消息内容
            //实际消息的长度
            int contentLen = packageDataLen1 - 8;
            //继续读取真正的消息内容
            int len = 0;        //本次读取数据长度
//            int readLen = 0;    //已读数据长度

            if(contentLen<=0) {
                System.out.println("实际消息的长度:"+packageDataLen2);
                System.out.println("接收到空消息！");
                return null;
            };
            byte[] bytes = new byte[contentLen];
            ByteArrayOutputStream msgos = new ByteArrayOutputStream();
            System.out.println(packageDataLen1);
            System.out.println("实际长度："+contentLen);
            msgBuffer.readBytes(bytes, 0, contentLen);
            msgos.write(bytes,0,contentLen);
//            while ((len = msgBuffer.readBytes(bytes, 0, contentLen - readLen)) != -1) {
//                msgos.write(bytes, 0, len);
//                readLen += len;
//                if (readLen == contentLen) {
//                    break;
//                }
//            }
            msgByte = msgos.toByteArray();

        }catch (Exception e){
            e.printStackTrace();
        }
        return msgByte;
    }

    /**
     * 将小端字节数据转为大端整数
     * @param dataLen
     * @param offset
     * @return
     */
    public static int bytes2bigInt(byte[] dataLen, int offset) {
        int resulteInt = 0;
        resulteInt = (int)((dataLen[offset] & 0xff)| ((dataLen[offset+1] & 0xff)<< 8) |((dataLen[offset+2] & 0xff)<<16) |((dataLen[offset+3] & 0xff)<<24));
        return resulteInt;
    }

    public static byte[] readFromStream(ByteBuf msgBuffer, int offset, int dataLength) {
        byte[] result  = new byte[dataLength];
        try {
            msgBuffer.readBytes(result,offset,dataLength);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
