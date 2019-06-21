package df.dyutil;

import df.Manager.GiftManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    public static String freeGiftUrl;
    public static String moneyGiftUrl;
    public static int roomId;
    private static Logger logger = LogManager.getLogger(Config.class);

    static {
        loadConfig();
    }

    public static void loadConfig(){
        Properties properties = new Properties();
        try {
            String path = System.getProperty("user.dir")+ File.separator+"config"+File.separator+"config.properties";
//            properties.load(GiftManager.class.getResourceAsStream("/config.properties"));
            properties.load(new FileInputStream(new File(path)));
            freeGiftUrl = properties.getProperty("freeGiftUrl");
            moneyGiftUrl = properties.getProperty("moneyGift");
            roomId = Integer.valueOf(properties.getProperty("roomId"));
            logger.info("加载配置文件完成！");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}
