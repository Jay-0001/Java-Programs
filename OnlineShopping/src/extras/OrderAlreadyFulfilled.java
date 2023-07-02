package extras;
public class OrderAlreadyFulfilled extends Exception{
    public OrderAlreadyFulfilled(String message) {
        super(message);
    }
}
