package df.bean.giftbean;

public class Giftinfo {
    private String id;

    private String name;

    private Integer gifttype;

    private Double price;

    private String pricename;

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

    @Override
    public String toString() {
        return "Giftinfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gifttype=" + gifttype +
                ", price=" + price +
                ", pricename='" + pricename + '\'' +
                '}';
    }

    public boolean compare(Giftinfo giftinfo){
        if(this.getName().equals(giftinfo.getName()) && this.getPricename().equals(giftinfo.getPricename())){
            return true;
        }else {
            return false;
        }
    }
}