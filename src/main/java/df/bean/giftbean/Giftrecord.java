package df.bean.giftbean;

public class Giftrecord {
    private Integer rid;

    private Integer gfid;

    private Integer isfree;

    private String gfname;

    private Integer uid;

    private String nn;

    private Integer level;

    private Integer gfcnt;

    private Double jiage;

    private Long gifttime;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getGfid() {
        return gfid;
    }

    public void setGfid(Integer gfid) {
        this.gfid = gfid;
    }

    public Integer getIsfree() {
        return isfree;
    }

    public void setIsfree(Integer isfree) {
        this.isfree = isfree;
    }

    public String getGfname() {
        return gfname;
    }

    public void setGfname(String gfname) {
        this.gfname = gfname == null ? null : gfname.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getNn() {
        return nn;
    }

    public void setNn(String nn) {
        this.nn = nn == null ? null : nn.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getGfcnt() {
        return gfcnt;
    }

    public void setGfcnt(Integer gfcnt) {
        this.gfcnt = gfcnt;
    }

    public Double getJiage() {
        return jiage;
    }

    public void setJiage(Double jiage) {
        this.jiage = jiage;
    }

    public Long getGifttime() {
        return gifttime;
    }

    public void setGifttime(Long gifttime) {
        this.gifttime = gifttime;
    }
}