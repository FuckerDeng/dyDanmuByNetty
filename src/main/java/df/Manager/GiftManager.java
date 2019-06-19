package df.Manager;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import df.dyutil.Config;
import df.dyutil.MyUtil;
import df.bean.giftbean.GiftInfo;

import java.util.*;

public class GiftManager {
    //免费礼物的映射表
    public static HashMap<String,GiftInfo> giftContainner = new HashMap<>();


    static {
        initGiftMap();
    }

    public static synchronized void initGiftMap (){
        try {
            System.out.println("从网络获取斗鱼礼物信息！");
            String freeGiftStr = MyUtil.getHtml(Config.freeGiftUrl);
            String moneyGiftStr = MyUtil.getHtml(Config.moneyGiftUrl);
            if(freeGiftStr=="" || moneyGiftStr ==""){
                System.out.println("获取免费礼物信息失败！");
                System.exit(0);
            }
            freeGiftStr = freeGiftStr.substring(17,freeGiftStr.length()-2);
            JSONObject freeJson = JSON.parseObject(freeGiftStr);
            Iterator<Map.Entry<String, Object>> freeData = freeJson.getJSONObject("data").entrySet().iterator();
            giftContainner.clear();
            while (freeData.hasNext()){
                Map.Entry<String, Object> next = freeData.next();
                GiftInfo gift = new GiftInfo();
                JSONObject value = (JSONObject) (next.getValue());
                gift.setId(next.getKey());
                gift.setGiftType(0);
                gift.setName(value.getString("name"));
                giftContainner.put(next.getKey(),gift);
            }

            moneyGiftStr = moneyGiftStr.substring(17,moneyGiftStr.length()-2);
//            System.out.println(moneyGiftStr);
            JSONObject moneyJson = JSON.parseObject(moneyGiftStr);
            JSONArray moneyData = moneyJson.getJSONArray("data");
            for(int i = 0;i<moneyData.size();i++){
                JSONObject md = moneyData.getJSONObject(i);
                GiftInfo gift = new GiftInfo();
                gift.setId(md.getString("id")+"");
                if(gift.getId()=="20000")
                gift.setGiftType(0);
                gift.setName(md.getString("name"));
                gift.setPriceName(md.getString("price_name"));
                gift.setPrice(Double.valueOf(gift.getPriceName().substring(0,gift.getPriceName().length()-2)));
                giftContainner.put(gift.getId(),gift);
            }
            System.out.println("从网络获取斗鱼礼物信息成功并加入容器！");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
