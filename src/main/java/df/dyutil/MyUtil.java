package df.dyutil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;

import java.io.IOException;

public class MyUtil {
    private static final Logger logger = LogManager.getLogger(MyUtil.class);
    public static OS getOs(){
        String osName = System.getProperty("os.name").toLowerCase();
        if(osName.contains("windows")){
            return OS.WINDOWS;
        }else if(osName.contains("linux")){
            return OS.LINUX;
        }else {
            return OS.UNIDENTIFIED;
        }
    }

    public static void waitwait(long millis ){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getHtml(String url) {
        String result = "";
        int k = 1;
        boolean issuccess = false;
        while (!issuccess){
            while (k<=5){
                try {
                    result = Jsoup.connect(url)
                            .timeout(600000)
                            .ignoreContentType(true)
                            .header("user-agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36")
                            .execute().body();
                    issuccess = true;
                    break;
                } catch (IOException e) {
                    logger.error("获取礼物数据失败，进行第 " +k+"次重试！");
                    e.printStackTrace();
                    continue;
                }
            }
            k = 1;
            MyUtil.waitwait(5000);
        }


        return result;
    }
}
