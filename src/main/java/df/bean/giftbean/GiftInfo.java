package df.bean.giftbean;

public class GiftInfo {
    private String id;
    private String name;
    private int giftType;
    private String priceName;
    private double price;
    private long gifTime;

    public GiftInfo() {
    }

    public GiftInfo(String id, String name, int giftType, String priceName) {
        this.id = id;
        this.name = name;
        this.giftType = giftType;
        this.priceName = priceName;
        this.price = Integer.valueOf(priceName.substring(0,priceName.length()-2));
    }

    public GiftInfo(String id, String name, int giftType, String priceName, int price) {
        this.id = id;
        this.name = name;
        this.giftType = giftType;
        this.priceName = priceName;
        this.price = price;
    }

    public long getGifTime() {
        return gifTime;
    }

    public void setGifTime(long gifTime) {
        this.gifTime = gifTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriceName() {
        return priceName;
    }

    public void setPriceName(String priceName) {
        this.priceName = priceName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getGiftType() {
        return giftType;
    }

    public void setGiftType(int giftType) {
        this.giftType = giftType;
    }

    @Override
    public String toString() {
        return "GiftInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", giftType=" + giftType +
                ", priceName='" + priceName + '\'' +
                ", price=" + price +
                '}';
    }
}
