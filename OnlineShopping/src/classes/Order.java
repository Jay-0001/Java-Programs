package classes;
import java.util.ArrayList;
import java.util.Date;
public class Order {
  private long orderId;
  private Date orderDate;
  private String orderStatus;
  private Privilege pCust;               //any other means of resolution ?
  private ValueAdd vCust;
  private double orderAmount,amountAfterDiscount;
  private ArrayList<Item> items = new ArrayList<>();
  public Order(long orderId, Date orderDate, String orderStatus, Privilege pCust, ValueAdd vCust, double orderAmount, double amountAfterDiscount) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.pCust = pCust;
        this.vCust = vCust;
        this.orderAmount = orderAmount;
        this.amountAfterDiscount = amountAfterDiscount;
  }
    public long getOrderId() {
        return orderId;
    }
    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }
    public Date getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public String getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    public Privilege getpCust() {
        return pCust;
    }
    public void setpCust(Privilege pCust) {
        this.pCust = pCust;
    }
    public ValueAdd getvCust() {
        return vCust;
    }
    public void setvCust(ValueAdd vCust) {
        this.vCust = vCust;
    }

    public double getOrderAmount() {
        return orderAmount;
    }
    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }
    public double getAmountAfterDiscount() {
        return amountAfterDiscount;
    }
    public void setAmountAfterDiscount(double amountAfterDiscount) {
        this.amountAfterDiscount = amountAfterDiscount;
    }
    public ArrayList<Item> getItems() {
        return items;
    }
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", orderStatus='" + orderStatus + '\'' +
                ", pCust=" + pCust +
                ", vCust=" + vCust +
                ", orderAmount=" + orderAmount +
                ", amountAfterDiscount=" + amountAfterDiscount +
                ", items=" + items +
                '}';
    }
}
