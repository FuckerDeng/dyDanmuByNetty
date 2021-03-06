package df;

import df.Manager.GiftManager;
import df.client.DouyuClient;
import df.dyutil.MyUtil;
import df.msghandler.Msg2DbHandler;
import df.msghandler.MsgParse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Hello world!
 *
 */
public class App 
{
    private static Logger logger = LogManager.getLogger(App.class);
    public static void main( String[] args )
    {
        try {

            initConfig();

            //启动每隔24小时就刷新下礼物容器内容任务
            new Timer("GiftManagerInitTask").scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    GiftManager.GetGiftMap();
                }
            },MyUtil.leftTimeToday(),24*60*60*1000);
            logger.info("任务：每天凌晨刷新奖励容器 启动成功！");


            //启动msg处理线程
            Thread msgHandlerTread = new MsgParse();
            msgHandlerTread.setDaemon(true);
            msgHandlerTread.start();
            logger.info("启动消息处理线程成功！");


            //启动礼物信息入库的线程
            Thread gift2DbTread = new Msg2DbHandler();
            gift2DbTread.setDaemon(true);
            gift2DbTread.start();
            logger.info("启动礼物信息入库线程成功！");

            //启动客户端
            DouyuClient client = new DouyuClient();
            client.start();

            Runtime.getRuntime().addShutdownHook(new Thread(()->{
                logger.info("程序结束，开始关闭连接....");
                if(client.channel !=null){
                    client.channel.close();
                }
            }));

//            System.out.println(MyUtil.getOs().equals(OS.WINDOWS));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private static void initConfig() {
        GiftManager.GetGiftMap();
    }


}
