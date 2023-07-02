package classes;
public class Supplier {
    private long supplierId,itemStock;
    private String name,address;
    private Item sItem;
    public Supplier(long supplierId, long itemStock, String name, String address, Item sItem) {
        this.supplierId = supplierId;
        this.itemStock = itemStock;
        this.name = name;
        this.address = address;
        this.sItem = sItem;
    }
    public long getSupplierId() {
        return supplierId;
    }
    public void setSupplierId(long supplierId) {
        this.supplierId = supplierId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Item getsItem() {
        return sItem;
    }
    public void setsItem(Item sItem) {
        this.sItem = sItem;
    }
    public long getItemStock() {
        return itemStock;
    }
    public void setItemStock(long itemStock) {
        this.itemStock = itemStock;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierId=" + supplierId +
                ", itemStock=" + itemStock +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", sItem=" + sItem +
                '}';
    }
}
