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

public class GiftManager {
    private static Logger logger = LogManager.getLogger(GiftManager.class);
    //免费礼物的映射表
    public static HashMap<String,Giftinfo> freeGiftContainner = new HashMap<>();
    public static HashMap<String,Giftinfo> moneyGiftContainner = new HashMap<>();

    public static HashMap<String,Giftinfo> tempFreeGiftContainner = new HashMap<>();
    private static HashMap<String,Giftinfo> tempMoneyGiftContainner = new HashMap<>();
    private static List<Giftinfo> toDB = new ArrayList<>();
    private static boolean firstFromDb = true;
    private static int giftNumm = 0;


    public static synchronized void GetGiftMap (){
        try {
            if(firstFromDb){
                logger.info("从数据库加载奖励道具信息！");
                boolean isInit = loadGiftFromDb();
                firstFromDb = false;
                if(isInit){
                    logger.info("从数据库加载礼物数量为："+giftNumm);
                    return;
                }
            }

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
                tempFreeGiftContainner.put(next.getKey(),gift);
                giftNumm++;
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

                    Giftinfo giftInfo = tempFreeGiftContainner.get(gift.getId());
                    if(giftInfo == null){
//                        logger.info("获取收费礼物信息：id-"+gift.getId()+"    name-"+gift.getName()+"    price-"+gift.getPricename());
                        Giftinfo money2 = tempMoneyGiftContainner.get(gift.getId());
                        if(money2 == null){
                            tempMoneyGiftContainner.put(gift.getId(),gift);
                            giftNumm++;
                            toDB.add(gift);

                        }else if(money2!=null && !gift.compare(money2)){
                            logger.error("非免费礼物中，同id不通价格： id="+giftInfo.getId()+"  price1="+gift.getPricename()+"  price2="+money2.getPricename());
                        }

                    }else {

                        if(!gift.compare(giftInfo)){
//                            logger.info("获取收费礼物信息：id-"+gift.getId()+"    name-"+gift.getName()+"    price-"+gift.getPricename());
                            logger.info("有礼物id冲突：id-"+gift.getId()+"\t新增为"+gift.getName()+"\t旧的为"+giftInfo.getName());
                            giftInfo.setName(gift.getName());
                            giftInfo.setGifttype(3);
                            giftInfo.setPricename(gift.getPricename());
                            giftInfo.setPrice(gift.getPrice());
                        }
                    }

                }
            }
            toDB.stream().forEach(gift -> logger.info(gift));
            initGiftMap();
            gift2db();


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
                freeGiftContainner.clear();
                moneyGiftContainner.clear();
                giftinfos.stream().forEach(info->{
                    if(info.getGifttype()==0 || info.getGifttype()==3){
                        freeGiftContainner.put(info.getId()+"",info);
                        giftNumm++;
                    }else {
                        moneyGiftContainner.put(info.getId()+"",info);
                        giftNumm++;
                    }
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



    public static synchronized void initGiftMap(){
        freeGiftContainner.clear();
        moneyGiftContainner.clear();
        freeGiftContainner.putAll(tempFreeGiftContainner);
        moneyGiftContainner.putAll(moneyGiftContainner);

        tempFreeGiftContainner.clear();
        tempMoneyGiftContainner.clear();
        logger.info("从网络获取斗鱼礼物信息成功并加入容器！共收集 "+  giftNumm+" 种礼物信息！");
        giftNumm = 0;
    }

    public static void gift2db(){
        SqlSession sqlSession = Dao.getSqlSession();
        GiftinfoMapper mapper = sqlSession.getMapper(GiftinfoMapper.class);
        try {
            mapper.truncateTable();
            mapper.insertBatch(toDB);
            sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
            logger.error("网络获取的礼物道具信息入库失败！");
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }


    }
}
