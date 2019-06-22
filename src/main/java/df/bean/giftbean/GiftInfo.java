package df.bean.giftbean;

public class Giftinfo {
    private String id;

    private String name;

    private Integer gifttype;

    private Double price;

    private String pricename;
    public Giftinfo(){}

    public Giftinfo(String id, String name, int giftType, String priceName) {
        this.id = id;
        this.name = name;
        this.gifttype = giftType;
        this.pricename = priceName;
        this.price = Double.valueOf(priceName.substring(0,priceName.length()-2));
    }

    public Giftinfo(String id, String name, int giftType, String priceName, double price) {
        this.id = id;
        this.name = name;
        this.gifttype = giftType;
        this.pricename = priceName;
        this.price = price;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getGifttype() {
        return gifttype;
    }

    public void setGifttype(Integer gifttype) {
        this.gifttype = gifttype;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPricename() {
        return pricename;
    }

    public void setPricename(String pricename) {
        this.pricename = pricename == null ? null : pricename.trim();
    }

    public boolean compare(Giftinfo giftInfo){
        if(this.getName().equals(giftInfo.getName()) & this.getPricename().equals(giftInfo.getPricename())){
            return true;
        }else {
            return false;
        }
    }
}