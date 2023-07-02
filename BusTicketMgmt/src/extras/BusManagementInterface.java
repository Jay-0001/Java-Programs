package extras;
import classes.Passenger;
import classes.Ticket;
import java.util.ArrayList;
import java.util.HashMap;

public interface BusManagementInterface {
    boolean issueTicket(int busNo,Ticket t) throws TicketAlreadyExists,LimitExceededException;
    HashMap<Integer,Integer> getCountOfSeniorCitizens();
    boolean cancelTicket(int busNo,int ticketNo) throws TicketDoesNotExist,InvalidBusException;
    ArrayList<Passenger> getPassengersByGender(String gender);
    long getCountOfPassengers(String source,String destination);
}
