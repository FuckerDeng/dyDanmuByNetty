package df.bean.msgbean;

/**
 * 弹幕消息
 * eg:
 * type@=chatmsg/rid@=58839/gid@=-9999/ct@=8/uid@=123456/nn@
 * =test/txt@=666/cid@=1111/ic@=icon/sahf@=0/level@=1/nl@=0/nc
 * @=0/cmt@=0/gt@=0/col@=0/rg@=0/pg@=0/dlv@=0/dc@=0/bdlv@
 * =0/gatin@=0/gatout@=0/chtin@=0/chtout@=0/repin@=0/repout@=
 * 0/bnn@=test/bl@=0/brid@=58839/hc@=0/ol@=0/rev@=0/hl@=0/ifs
 * @=0/p2p@=0/el@=eid@AA=1@ASetp@AA=1@ASsc@AA=1@AS/
 */
public class DanmuMsg extends Msg{


    //弹幕组id
    private int gid;

    //房间id
    private int rid;

    //发送者uid
    private int uid;

    //发送者昵称
    private String nn;

//    弹幕文本内容
    private String txt;

    //弹幕唯一ID
    private String cid;

    //用户等级
    private int  level;

    //礼物头衔：默认值0（表示没有头衔）
    private int gt;

    //颜色：默认值0（表示默认颜色弹幕）
    private int col;

    //客户端类型：默认值0
    private int ct;

    //房间权限组：默认值1（表示普通权限用户）
    private int rg;

    //平台权限组：默认值1（表示普通权限用户）
    private int pg;

    //弹幕具体类型: 默认值0（普通弹幕）
    private int cmt;

    //用户头像
    private String ic;

    //贵族等级
    private int nl;

    //贵族弹幕标识,0-非贵族弹幕,1-贵族弹幕,默认值0
    private int nc;

    //徽章昵称：徽章就是主播牌子，比如团子粉，就是 猪叫团
    private String bnn;

    //徽章等级
    private int bl;

    //徽章房间id：徽章所属主播的房间号
    private int brid;



    @Override
    public String toString() {
        return "DanmuMsg{" +
                "gid=" + gid +
                ", rid=" + rid +
                ", uid=" + uid +
                ", nn='" + nn + '\'' +
                ", txt='" + txt + '\'' +
                ", cid='" + cid + '\'' +
                ", level=" + level +
                ", gt=" + gt +
                ", col=" + col +
                ", ct=" + ct +
                ", rg=" + rg +
                ", pg=" + pg +
                ", cmt=" + cmt +
                ", ic='" + ic + '\'' +
                ", nl=" + nl +
                ", nc=" + nc +
                ", bnn='" + bnn + '\'' +
                ", bl=" + bl +
                ", brid=" + brid +
                '}';
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
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

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getGt() {
        return gt;
    }

    public void setGt(int gt) {
        this.gt = gt;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getCt() {
        return ct;
    }

    public void setCt(int ct) {
        this.ct = ct;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public int getPg() {
        return pg;
    }

    public void setPg(int pg) {
        this.pg = pg;
    }

    public int getCmt() {
        return cmt;
    }

    public void setCmt(int cmt) {
        this.cmt = cmt;
    }

    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }

    public int getNl() {
        return nl;
    }

    public void setNl(int nl) {
        this.nl = nl;
    }

    public int getNc() {
        return nc;
    }

    public void setNc(int nc) {
        this.nc = nc;
    }

    public String getBnn() {
        return bnn;
    }

    public void setBnn(String bnn) {
        this.bnn = bnn;
    }

    public int getBl() {
        return bl;
    }

    public void setBl(int bl) {
        this.bl = bl;
    }

    public int getBrid() {
        return brid;
    }

    public void setBrid(int brid) {
        this.brid = brid;
    }
}
