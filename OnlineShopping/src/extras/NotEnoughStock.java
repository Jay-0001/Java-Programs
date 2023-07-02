package extras;
public class NotEnoughStock extends Exception{
    public NotEnoughStock(String message) {
        super(message);
    }
}
