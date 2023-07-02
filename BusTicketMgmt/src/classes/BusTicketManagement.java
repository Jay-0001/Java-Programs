package classes;
import extras.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class BusTicketManagement implements BusManagementInterface{
    ArrayList<Bus> buses;
    public BusTicketManagement(ArrayList<Bus> b) {
        buses=b;
    }
    @Override
    public boolean issueTicket(int busNo, Ticket t) throws TicketAlreadyExists, LimitExceededException {
        TicketNoGenerator tg = new TicketNoGenerator();
        for(Bus b:buses){
            if(b.getBusNo()==busNo){
                if(b.tickets.size()<=50) {
                    if(b.tickets.contains(t))
                        throw new TicketAlreadyExists("ticket already exists");
                    else {
                        t.setTicketNo(tg.generateTicketNo(busNo));
                        b.tickets.add(t);
                        return true;
                    }
                }
                else
                    throw new LimitExceededException("Passenger Limit Reached");
            }
        }
        return false;
    }

    @Override
    public HashMap<Integer, Integer> getCountOfSeniorCitizens() {
        HashMap<Integer,Integer> seniors = new HashMap<>();
        for(Bus b : buses){
            int count=0;
            for(Ticket t : b.tickets){
                if(t.getTraveller().getClass().getSimpleName().equals("SeniorCitizen")) //equals() is more suitable than == for string comp, == fails here
                    count++;
            }
            seniors.put(b.getBusNo(),count);
        }
        return seniors;
    }

    @Override
    public boolean cancelTicket(int busNo, int ticketNo) throws TicketDoesNotExist, InvalidBusException {
        for(Bus b:buses){
            if(b.getBusNo()==busNo){
                Iterator<Ticket> itr=b.tickets.iterator();
                Ticket t;
                while(itr.hasNext()){
                    t=itr.next();
                    if(t.getTicketNo()==ticketNo){
                        itr.remove();
                        return true;
                    }
                }
                throw new TicketDoesNotExist();
            }
        }
        throw new InvalidBusException();
    }

    @Override
    public ArrayList<Passenger> getPassengersByGender(String gender) {
        ArrayList<Passenger> passengers = new ArrayList<>();
        for(Bus b : buses){
            Passenger p;
            for(Ticket t : b.tickets){
                p=t.getTraveller();
                if(p.getGender()==gender){
                    passengers.add(p);
                }
            }
        }
        return passengers;
    }

    @Override
    public long getCountOfPassengers(String source, String destination) {
        long count =0;
        for(Bus b : buses){
            if(b.getStartStation()==source&&b.getDestinationStation()==destination)
                count=b.tickets.size();
        }
        return count;
    }

    @Override
    public String toString() {
        return "BusTicketManagement{" +
                "buses=" + buses +
                '}';
    }
}
