package classes;
public class Ticket {
    private int ticketNo;
    private double ticketPrice;
    private Passenger traveller;
    public Ticket() {
    }
    public Ticket(int ticketNo, double ticketPrice, Passenger traveller) {
        this.ticketNo=ticketNo;
        this.ticketPrice = ticketPrice;
        this.traveller = traveller;
    }
    public int getTicketNo() {
        return ticketNo;
    }
    public void setTicketNo(int ticketNo) {
        this.ticketNo = ticketNo;
    }
    public double getTicketPrice() {
        return ticketPrice;
    }
    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
    public Passenger getTraveller() {
        return traveller;
    }
    public void setTraveller(Passenger traveller) {
        this.traveller = traveller;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketNo=" + ticketNo +
                ", ticketPrice=" + ticketPrice +
                ", traveller=" + traveller +
                '}';
    }
}
