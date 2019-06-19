package df.dyutil;

import df.Manager.GiftManager;

import java.io.IOException;
import java.util.Properties;

public class Config {
    public static String freeGiftUrl;
    public static String moneyGiftUrl;
    public static int roomId;

    static {
        loadConfig();
    }

    public static void loadConfig(){
        Properties properties = new Properties();
        try {
            properties.load(GiftManager.class.getResourceAsStream("/config.properties"));
            freeGiftUrl = properties.getProperty("freeGiftUrl");
            moneyGiftUrl = properties.getProperty("moneyGift");
            roomId = Integer.valueOf(properties.getProperty("roomId"));
            System.out.println("加载配置文件完成！");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}
