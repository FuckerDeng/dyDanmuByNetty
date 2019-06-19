package df.Manager;

import df.bean.msgbean.Msg;

import java.util.concurrent.LinkedTransferQueue;

public class MsgManger {
    //无上限阻塞队列，注意下其他队列的用法
    public static LinkedTransferQueue<String> msgQueue = new LinkedTransferQueue<>();

    //无上限阻塞队列，注意下其他队列的用法
    public static LinkedTransferQueue<Msg> msgHandedQueue = new LinkedTransferQueue<>();

    //最后一次接收到消息的时间
    public static long lastMsgTime = 0;

    public static void push(String msg){
        msgQueue.put(msg);
    }

    public static String poll(){
        return msgQueue.poll();
    }

    public static void pushHandedMsg(Msg msg){
        msgHandedQueue.put(msg);
    }

    public static Msg pollHandedMsg(){
        return msgHandedQueue.poll();
    }
}
