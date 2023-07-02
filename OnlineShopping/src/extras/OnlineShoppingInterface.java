package extras;
import classes.*;
import java.util.ArrayList;
import java.util.HashMap;

public interface OnlineShoppingInterface {
 boolean addOrder(Order o);
 boolean cancelOrder(long orderId) throws OrderNotFound;
 boolean cancelItem(long orderId,int itemId) throws OrderNotFound;
 boolean fulfillOrder(long orderId) throws OrderAlreadyFulfilled,NotEnoughStock;
 HashMap<Long,Long> getStockDetails();
 ArrayList<Order> listOrderByPrice();
}
