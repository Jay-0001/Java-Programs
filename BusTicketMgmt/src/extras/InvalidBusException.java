package extras;
public class InvalidBusException extends Exception{
    public InvalidBusException() {
    }
    @Override
    public String toString() {
        return "InvalidBusException--invalid busNo";
    }
}
