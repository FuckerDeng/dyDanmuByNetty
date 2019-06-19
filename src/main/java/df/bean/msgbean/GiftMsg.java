package df.bean.msgbean;

public class GiftMsg extends Msg{
    private int rid;
    private int gid;
    private int gfid;
    private String gs;
    private int uid;
    private String nn;
    //大礼物标识：默认值为0（标识小礼物）
    private int bg;
    //用户头像
    private String ic;
    //礼物关联的特效id
    private int eid;
    //用户等级
    private int level;
    //主播体重
    private String dw;
    //礼物个数：默认值为1（表示1个礼物）
    private int gfcnt;
    //礼物连击次数L默认值为1（表示1连击）


    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public int getGfid() {
        return gfid;
    }

    public void setGfid(int gfid) {
        this.gfid = gfid;
    }

    public String getGs() {
        return gs;
    }

    public void setGs(String gs) {
        this.gs = gs;
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

    public int getBg() {
        return bg;
    }

    public void setBg(int bg) {
        this.bg = bg;
    }

    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getDw() {
        return dw;
    }

    public void setDw(String dw) {
        this.dw = dw;
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
                ", gid=" + gid +
                ", gfid=" + gfid +
                ", gs='" + gs + '\'' +
                ", uid=" + uid +
                ", nn='" + nn + '\'' +
                ", bg=" + bg +
                ", ic='" + ic + '\'' +
                ", eid=" + eid +
                ", level=" + level +
                ", dw='" + dw + '\'' +
                ", gfcnt=" + gfcnt +
                '}';
    }
}
