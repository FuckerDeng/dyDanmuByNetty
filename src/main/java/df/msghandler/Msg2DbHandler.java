package df.msghandler;

import df.Manager.GiftManager;
import df.Manager.MsgManger;
import df.bean.giftbean.Giftinfo;
import df.bean.giftbean.Giftrecord;
import df.db.Dao;
import df.bean.msgbean.GiftMsg;
import df.bean.msgbean.Msg;
import df.db.mappers.GiftrecordMapper;
import df.dyutil.Config;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Msg2DbHandler extends Thread {
    private Logger logger = LogManager.getLogger(Msg2DbHandler.class);
    @Override
    public void run() {
        while (true){
            Msg handedMsg = MsgManger.pollHandedMsg();
            if(handedMsg == null) {
                continue;
            }

            if(handedMsg.getType().equals("dgb")){
                GiftMsg giftMsg = (GiftMsg) handedMsg;
                System.out.println(giftMsg);
                continue;
//                Giftinfo giftInfo = GiftManager.giftContainner.get(giftMsg.getGfid()+"");
//                giftInfo = GiftManager.giftContainner.get(giftMsg.getGfid()+"");
//                if(giftInfo==null){
//                    logger.info(String.format("无法识别的礼物id：%d",giftMsg.getGfid()));
//                    continue;
//                }
//                Giftrecord giftrecord = new Giftrecord();
//                giftrecord.setRid(Config.roomId);
//                giftrecord.setGfname(giftInfo.getName());
//                giftrecord.setGfid(giftMsg.getGfid());
//                giftrecord.setIsfree(giftInfo.getGifttype());
//                giftrecord.setUid(giftMsg.getUid());
//                giftrecord.setNn(giftMsg.getNn());
//                giftrecord.setLevel(giftMsg.getLevel());
//                giftrecord.setGfcnt(giftMsg.getGfcnt());
//                giftrecord.setJiage(giftInfo.getPrice());
//                giftrecord.setGifttime(System.currentTimeMillis());
//
//                SqlSession sqlSession = Dao.getSqlSession();
//                GiftrecordMapper mapper = sqlSession.getMapper(GiftrecordMapper.class);
//                try {
//                    mapper.insert(giftrecord);
//                    sqlSession.commit();
//                    if(giftrecord.getIsfree()==0){
//                        logger.info(String.format("%s  赠送免费礼物：%s  %d个",giftrecord.getNn(),giftrecord.getGfname(),giftrecord.getGfcnt()));
//                    }else{
//                        logger.info(String.format("%s  赠送收费礼物：%s  %d个，价值 %.2f元",giftrecord.getNn(),giftrecord.getGfname(),giftrecord.getGfcnt(),giftrecord.getJiage()*giftrecord.getGfcnt()));
//                    }
//
//                }catch (Exception e){
//                    sqlSession.rollback();
//                    e.printStackTrace();
//                }finally {
//                    Dao.closeSession(sqlSession);
//                }

            }

        }
    }
}
