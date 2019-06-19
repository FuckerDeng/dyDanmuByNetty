package df;

import df.client.DouyuClient;
import df.dyutil.MyUtil;
import df.dyutil.OS;
import df.msghandler.Msg2DbHandler;
import df.msghandler.MsgParse;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {


            //启动msg处理线程
            Thread msgHandlerTread = new MsgParse();
            msgHandlerTread.setDaemon(true);
            msgHandlerTread.start();
            System.out.println("启动消息处理线程成功！");

            //启动礼物信息入库的线程
            Thread gift2DbTread = new Msg2DbHandler();
            gift2DbTread.setDaemon(true);
            gift2DbTread.start();
            System.out.println("启动礼物信息入库线程成功！");

            //启动客户端
            DouyuClient client = new DouyuClient();
            client.start();

            Runtime.getRuntime().addShutdownHook(new Thread(()->{
                System.out.println("程序结束，开始关闭连接....");
                if(client.channel !=null){
                    client.channel.close();
                }
            }));

//            System.out.println(MyUtil.getOs().equals(OS.WINDOWS));
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
