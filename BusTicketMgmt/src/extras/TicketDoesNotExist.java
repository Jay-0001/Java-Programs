package extras;
public class TicketDoesNotExist extends Exception{
    public TicketDoesNotExist() {
    }
    @Override
    public String toString() {
        return "TicketDoesNotExist--invalid ticketNo";
    }
}
