package df.Manager;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import df.bean.giftbean.Giftinfo;
import df.db.Dao;
import df.db.mappers.GiftinfoMapper;
import df.dyutil.Config;
import df.dyutil.MyUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class GiftManager2 {
    private static Logger logger = LogManager.getLogger(GiftManager.class);
    //免费礼物的映射表
    public static HashMap<String,Giftinfo> giftContainner = new HashMap<>();
    private static HashMap<String,Giftinfo> freeGiftContainner = new HashMap<>();
    private static HashMap<String,Giftinfo> moneyGiftContainner = new HashMap<>();
    private static List<Giftinfo> toDB = new ArrayList<>();
    private static boolean firstFromDb = true;


    public static synchronized void GetGiftMap (){
        try {

            logger.info("从网络获取斗鱼礼物信息！");
            String freeGiftStr = MyUtil.getHtml(Config.freeGiftUrl);
            if(freeGiftStr==""){
                logger.error("获取免费礼物信息失败！程序退出。。");
                System.exit(0);
            }
            freeGiftStr = freeGiftStr.substring(17,freeGiftStr.length()-2);
            JSONObject freeJson = JSON.parseObject(freeGiftStr);
            Iterator<Map.Entry<String, Object>> freeData = freeJson.getJSONObject("data").entrySet().iterator();
//            giftContainner.clear();
            while (freeData.hasNext()){
                Map.Entry<String, Object> next = freeData.next();
                Giftinfo gift = new Giftinfo();
                JSONObject value = (JSONObject) (next.getValue());
                gift.setId(next.getKey());
                gift.setGifttype(0);
                gift.setName(value.getString("name"));
//                logger.info("获取免费礼物信息：id-"+gift.getId()+"    name-"+gift.getName());
                freeGiftContainner.put(next.getKey(),gift);
                toDB.add(gift);
            }
            String moneyGiftStr;
            for(int i = 0 ;i<300;i++){
                logger.info("抓取第 "+(i+1)+" 次礼物道具，总计300次！");
                moneyGiftStr="";
                String moneyGiftUrl = Config.moneyGiftUrl +getUrlIndex(i)+".json";
                moneyGiftStr = MyUtil.getHtml(moneyGiftUrl);
                if(moneyGiftStr.equals("")){
                    continue;
                }
                moneyGiftStr = moneyGiftStr.substring(17,moneyGiftStr.length()-2);
//            System.out.println(moneyGiftStr);
                JSONObject moneyJson = JSON.parseObject(moneyGiftStr);
                JSONArray moneyData = moneyJson.getJSONArray("data");
                for(int j = 0;j<moneyData.size();j++){
                    JSONObject md = moneyData.getJSONObject(j);
                    Giftinfo gift = new Giftinfo();
                    gift.setId(md.getString("id")+"");
                    if(gift.getId().equals("20000") ||gift.getId().equals("20008") ){
                        gift.setGifttype(0);
                    }else{
                        gift.setGifttype(1);
                    }
                    gift.setName(md.getString("name"));
                    gift.setPricename(md.getString("price_name"));
                    gift.setPrice(Double.valueOf(gift.getPricename().substring(0,gift.getPricename().length()-2)));
                    moneyGiftContainner.put(gift.getId(),gift);

                }
            }
            for(int i = 0;i<freeGiftContainner.size();i++){
                Giftinfo free = freeGiftContainner.get(i);
                for(int j = 0;i<moneyGiftContainner.size();j++){
                    Giftinfo money = moneyGiftContainner.get(j);
                    if(free.getName().equals(money.getName())){
                        System.out.println("free-"+free.getId()+" "+free.getName()+"==money-"+money.getId()+" "+money.getName());
                    }
                }
            }
            logger.info("从网络获取斗鱼礼物信息成功并加入容器！共收集 "+giftContainner.size()+" 种礼物信息！");

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private static boolean loadGiftFromDb() {
        SqlSession sqlSession = Dao.getSqlSession();
        GiftinfoMapper mapper = sqlSession.getMapper(GiftinfoMapper.class);
        try {
            List<Giftinfo> giftinfos = mapper.selectAll();
            sqlSession.commit();
            if(giftinfos.size()>300){
                giftContainner.clear();
                giftinfos.stream().forEach(info->{
                    giftContainner.put(info.getId(),info);
                });
                return true;
            }
            return false;
        }catch (Exception e){
            sqlSession.rollback();
            e.printStackTrace();
            return false;
        }finally {
            sqlSession.close();
        }
    }

    public static String getUrlIndex(int i){
        if(i<10){
            return "2000" + i;
        }else if(i<100){
            return "200" + i;
        }else {
            return i+"";
        }
    }



//    public static synchronized void initGiftMap(){
//        giftContainner.clear();
//        giftContainner.putAll(tempGiftContainner);
//        tempGiftContainner.clear();
//    }

    public static void gift2db(){
        SqlSession sqlSession = Dao.getSqlSession();
        GiftinfoMapper mapper = sqlSession.getMapper(GiftinfoMapper.class);
        try {
            mapper.truncateTable();
            mapper.insertBatch(toDB);
            sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }


    }
}
