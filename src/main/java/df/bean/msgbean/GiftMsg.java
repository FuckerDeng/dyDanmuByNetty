package df.bean.msgbean;

public class GiftMsg extends Msg{
    private int rid;
    private int gfid;

    private int uid;
    //用户名称
    private String nn;
    //用户头像
    private String ic;
    //用户等级
    private int level;

    //礼物个数：默认值为1（表示1个礼物）
    private int gfcnt;



    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }


    public int getGfid() {
        return gfid;
    }

    public void setGfid(int gfid) {
        this.gfid = gfid;
    }



    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getNn() {
        return nn;
    }

    public void setNn(String nn) {
        this.nn = nn;
    }



    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }



    public int getGfcnt() {
        return gfcnt;
    }

    public void setGfcnt(int gfcnt) {
        this.gfcnt = gfcnt;
    }


    @Override
    public String toString() {
        return "GiftMsg{" +
                "rid=" + rid +
                ", gfid=" + gfid +
                ", uid=" + uid +
                ", nn='" + nn + '\'' +
                ", ic='" + ic + '\'' +
                ", level=" + level +
                ", gfcnt=" + gfcnt +
                '}';
    }
}
