package df.msghandler;



import df.Manager.MsgManger;
import df.dyutil.MyUtil;
import df.bean.msgbean.DanmuMsg;
import df.bean.msgbean.GiftMsg;
import df.bean.msgbean.LoginMsg;
import df.bean.msgbean.Msg;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Set;


public class MsgParse extends Thread{

    @Override
    public void run() {
        while (true){
            String msgString = MsgManger.poll();

            if(msgString == null) {
                continue;
            }

            Msg msg = parseMsg(msgString);

            if(msg!=null){
                MsgManger.pushHandedMsg(msg);
//                if(msg.getType()=="dgb") System.out.println("礼物消息放入入库队列");

            }

        }
    }

    private Msg parseMsg(String msgString) {
        String[] splits = msgString.split("/");
//        /el@=eid@AA=1@ASetp@AA=1@ASsc@AA=1@AS/
//        eid=1/etp@=1/sc@=1/
        Msg msg = null;
        HashMap<String,Object> keyValues = new HashMap<>();

        keyValues = msg2map(splits);
//        System.out.println(keyValues.get("type")+""+keyValues);
        switch ((String)keyValues.get("type")){
            case "loginres":
                msg = new LoginMsg();
                break;
            case "chatmsg":
                msg = new DanmuMsg();
                break;
            case "dgb":
                msg = new GiftMsg();
                break;
                default:
                    System.out.println("未处理的msg类型："+keyValues.get("type"));
                    break;

        }
        if(msg!=null) {
            initValue(keyValues,msg,msg.getClass());
        }
        return msg;
    }

    public void initValue(HashMap<String,Object> keyValues,Msg msg,Class clazz){
        msg.setType((String) keyValues.get("type"));
        Field[] declaredFields = clazz.getDeclaredFields();
        Set<String> keys = keyValues.keySet();
        for(Field f : declaredFields){
            f.setAccessible(true);
            for(String key :keys){
                if(key.equals(f.getName())){
                    try {
                        if(f.getGenericType().getTypeName().equals("int")){
                            f.set(msg,Integer.parseInt((String) keyValues.get(key)));
                        }else {
                            f.set(msg,(String) keyValues.get(key));
                        }

                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }

    }

    //序列化规定 如下：
//        1键key和值value直接采用‘@=’分割
//        2数组采用‘/’分割
//        3如果key或者value中含有字符‘/’，则使用‘@S’转义
//        4如果key或者value中含有字符‘@’，使用‘@A’转义
//        举例：
//        (1) 多个键值对数据：key1@=value1/key2@=value2/key3@=value3/
//        (2) 数组数据：value1/value2/value3/
    private HashMap<String,Object> msg2map(String[] splits) {
        HashMap<String,Object> keyValueMap = new HashMap<>();
        for(String split :splits){

            if(split.trim().equals("")) continue;
            String[] keyValue = split.split("@=");
            if(keyValue.length==1){
                keyValueMap.put(keyValue[0],"");
                continue;
            }

            if(!keyValue[1].contains("@A")){

                keyValueMap.put(keyValue[0],keyValue[1].replace("@S","/"));
                continue;
            }

            String value = keyValue[1].replace("@AA", "@").replace("@AS", "/").replace("@A","@").replace("@S","/");
            HashMap<String,String> values = new HashMap<>();
            String[] ss = value.split("/");
            for(String s:ss){
                if(s.trim().equals("")) continue;
                String[] var1 = s.split("@=");
                if(var1.length ==1){
                    values.put(var1[0],"");
                }else {
                    values.put(var1[0],var1[1]);
                }

            }
            keyValueMap.put(keyValue[0],values);

        }

        return keyValueMap;
    }




}
