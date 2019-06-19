package df.msghandler;

import df.Manager.GiftManager;
import df.Manager.MsgManger;
import df.bean.giftbean.Giftrecord;
import df.db.Dao;
import df.bean.giftbean.GiftInfo;
import df.bean.msgbean.GiftMsg;
import df.bean.msgbean.Msg;
import df.db.mappers.GiftrecordMapper;
import org.apache.ibatis.session.SqlSession;

public class Msg2DbHandler extends Thread {
    @Override
    public void run() {
        while (true){
            Msg handedMsg = MsgManger.pollHandedMsg();
            if(handedMsg == null) {
                continue;
            }

            if(handedMsg.getType().equals("dgb")){
                GiftMsg giftMsg = (GiftMsg) handedMsg;
                GiftInfo giftInfo = GiftManager.giftContainner.get(giftMsg.getGfid()+"");
                if(giftInfo ==null){
                    GiftManager.initGiftMap();
                }
                giftInfo = GiftManager.giftContainner.get(giftMsg.getGfid()+"");
                if(giftInfo==null){
                    System.out.printf("有礼物信息未获取到：%d  %s",giftMsg.getGfid());
                    continue;
                }
                Giftrecord giftrecord = new Giftrecord();
                giftrecord.setGfid(giftMsg.getGfid());
                giftrecord.setIsfree(giftInfo.getGiftType());
                giftrecord.setUid(giftMsg.getUid());
                giftrecord.setNn(giftMsg.getNn());
                giftrecord.setLevel(giftMsg.getLevel());
                giftrecord.setGfcnt(giftMsg.getGfcnt());
                giftrecord.setJiage(giftInfo.getPrice());
                giftrecord.setGifttime(System.currentTimeMillis());

                SqlSession sqlSession = Dao.getSqlSession();
                GiftrecordMapper mapper = sqlSession.getMapper(GiftrecordMapper.class);
                try {
                    mapper.insert(giftrecord);
                    sqlSession.commit();
                    if(giftrecord.getIsfree()==0){
                        System.out.printf("%s  赠送免费礼物：%s  %d个\n",giftrecord.getNn(),giftrecord.getGfname(),giftrecord.getGfcnt());
                    }else{
                        System.out.printf("%s  赠送收费礼物：%s  %d个，价值 %d元\n",giftrecord.getNn(),giftrecord.getGfname(),giftrecord.getGfcnt(),giftrecord.getJiage());
                    }

                }catch (Exception e){
                    sqlSession.rollback();
                    e.printStackTrace();
                }finally {
                    sqlSession.close();
                }

            }

        }
    }
}
