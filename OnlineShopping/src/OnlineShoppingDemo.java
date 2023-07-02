import classes.*;
import extras.*;
import java.util.Date;
import java.util.ArrayList;

//Must be able to picture the interdependencies between classes based on the functions
public class OnlineShoppingDemo {
    public static void main(String[] args) {
        ArrayList<Order> orders = new ArrayList<Order>();
        ArrayList<Supplier> suppliers = new ArrayList<>();

        Item item1=new Item(90001,1,"Pen02",100.00);
        suppliers.add(new Supplier(19001,20,"Supplier1","city 0",item1));
        Item item2=new Item(90002,5,"Box03",500.00);
        suppliers.add(new Supplier(19002,20,"Supplier2","city 0",item2));
        Item item3=new Item(90003,4,"Clock03",00.00);
        suppliers.add(new Supplier(19003,30,"Supplier3","city 0",item3));
        Item item4=new Item(90004,2,"Pen01",200.00);
        suppliers.add(new Supplier(19004,20,"Supplier4","city 0",item4));
        Item item5=new Item(90005,10,"Box02",1000.00);
        suppliers.add(new Supplier(19005,20,"Supplier5","city 0",item5));
        Item item6=new Item(90006,8,"Clock01",800.00);
        suppliers.add(new Supplier(19006,40,"Supplier6","city 0",item6));


        Order ord = (new Order(101,new Date(2023,02,11),"",
                new Privilege("privileged1",new Date(2000,06,15),"M","p001","city1","9090908080","p01@mail.com",10),
                null,1000.00,0.00
        ));
        ord.getItems().add(item1);
        ord.getItems().add(item2);
        ord.getItems().add(item3);
        orders.add(ord);

        ord = (new Order(102,new Date(2023,02,11),"",null,
                new ValueAdd("Valued1",new Date(2000,06,15),"M","p001","city1","9090908080","p01@mail.com",500),2000.00,0.00
        ));
        ord.getItems().add(item4);
        ord.getItems().add(item5);
        ord.getItems().add(item6);
        orders.add(ord);

        OnlineShoppingSystem oss = new OnlineShoppingSystem(suppliers);
        for(Order o:orders)
            System.out.println(oss.addOrder(o));
        System.out.println(oss);
        try {
            System.out.println(oss.cancelOrder(102));
            System.out.println(oss.cancelItem(101,90001));
        }catch(OrderNotFound onf){
            System.out.println(onf.getMessage());
        }
        System.out.println(oss);
        System.out.println("before fulfilling"+oss.suppliers);
        System.out.println(oss.getStockDetails());
        try{
            oss.fulfillOrder(101);
        }catch(OrderAlreadyFulfilled oaf){
            System.out.println(oaf.getMessage());
        }catch(NotEnoughStock nes){
            System.out.println(nes.getMessage());
        }
        System.out.println(oss);
        System.out.println("after fulfilling"+oss.suppliers);
        System.out.println(oss.getStockDetails());                      //some mishap in further updation of stock quantity in further items
    }
}