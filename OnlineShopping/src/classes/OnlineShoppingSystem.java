package classes;
import extras.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class OnlineShoppingSystem implements OnlineShoppingInterface{
    public ArrayList<Order> ABCCart = new ArrayList<>();
    public ArrayList<Supplier> suppliers = new ArrayList<>();
    public OnlineShoppingSystem(ArrayList<Supplier> suppliers) {
        this.suppliers=suppliers;
    }
    @Override
    public boolean addOrder(Order o) {
        if(o.getpCust()==null)
            o.setAmountAfterDiscount(o.getOrderAmount()-o.getvCust().getBonusPoints()*0.1);
        else
            o.setAmountAfterDiscount(o.getOrderAmount()-((o.getpCust().getDiscountPercent()/100)*o.getOrderAmount()));
        o.setOrderStatus("In-progress");
        ABCCart.add(o);
        return true;
    }

    @Override
    public boolean cancelOrder(long orderId) throws OrderNotFound {
        Iterator<Order> itr = ABCCart.iterator();
        Order ord;
        while(itr.hasNext()){
            ord=itr.next();
            if(ord.getOrderId()==orderId) {
                itr.remove();
                return true;
            }
        }
        throw new OrderNotFound("Order with given Id does not exist");
    }

    @Override
    public boolean cancelItem(long orderId, int itemId) throws OrderNotFound {
        for(Order ord:ABCCart){
            Iterator<Item> itm = ord.getItems().iterator();
            Item i;
            while(itm.hasNext()){
                i=itm.next();
                if(i.getItemId()==itemId){
                    itm.remove();
                    return true;
                }
            }
        }
        throw new OrderNotFound("No order with given Id is found");
    }

    @Override
    public boolean fulfillOrder(long orderId) throws OrderAlreadyFulfilled, NotEnoughStock {
        for(Order ord : ABCCart){
            if(ord.getOrderId()==orderId) {
                if (ord.getOrderStatus().equals("Fulfilled"))
                    throw new OrderAlreadyFulfilled("Order has already been fulfilled");
                else {
                    for (Item itm : ord.getItems()) {
                        for (Supplier s : suppliers) {
                            if (s.getsItem() == itm) {
                                if(s.getItemStock()<itm.getQuantity())
                                    throw new NotEnoughStock("Item quantity exceeds stock");
                                else {
                                    ord.setOrderStatus("Fulfilled");
                                    s.setItemStock(s.getItemStock() - itm.getQuantity());
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public HashMap<Long,Long> getStockDetails() {
        HashMap<Long,Long> details = new HashMap<>();
        long k;
        for(Supplier sp : suppliers){
            k=sp.getsItem().getItemId();
            details.put(k,details.getOrDefault(k,0L)+sp.getItemStock());   //usage of 0L
        }
        return details;
    }

    @Override
    public ArrayList<Order> listOrderByPrice() {
        return null;
    }

    @Override
    public String toString() {
        return "OnlineShoppingSystem{" +
                "ABCCart=" + ABCCart +
                '}';
    }
}
