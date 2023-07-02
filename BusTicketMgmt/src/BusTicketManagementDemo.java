import classes.*;
import extras.*;

import java.util.ArrayList;

public class BusTicketManagementDemo {
    public static void main(String[] args) {
        ArrayList<Bus> transport = new ArrayList<>();
        transport.add(new Bus(101,"city1","city2"));
        transport.add(new Bus(102,"city2","city5"));
        transport.add(new Bus(103,"city3","city4"));
        BusTicketManagement mgmt = new BusTicketManagement(transport);
        Ticket tk;
        for(int i=1;i<50;i++){
                if(i<=25)
                    tk = new Ticket(0,100,new Passenger("passenger"+i,"M","city1","city2"));
                else
                    tk = new Ticket(0,100,new SeniorCitizen("passenger"+i,"F","city1","city2",70));
                try {
                    mgmt.issueTicket(101, tk);
                }catch (TicketAlreadyExists tae){
                    System.out.println(tae.getMessage());
                }catch (LimitExceededException lee){
                    System.out.println(lee.getMessage());
                }
        }

        for(int i=51;i<75;i++){
            if(i<=63)
                tk = new Ticket(0,200,new Passenger("passenger"+i,"M","city2","city5"));
            else
                tk = new Ticket(0,200,new Passenger("passenger"+i,"F","city2","city5"));
            try {
                mgmt.issueTicket(102, tk);
            }catch (TicketAlreadyExists tae){
                System.out.println(tae.getMessage());
            }catch (LimitExceededException lee){
                System.out.println(lee.getMessage());
            }
        }
        for(int i=75;i<100;i++) {
            if (i <= 87)
                tk = new Ticket(0, 200, new SeniorCitizen("passenger" + i, "M", "city2", "city5", 60));
            else
                tk = new Ticket(0, 200, new Passenger("passenger" + i, "F", "city2", "city5"));
            try {
                mgmt.issueTicket(103, tk);
            } catch (TicketAlreadyExists tae) {
                System.out.println(tae.getMessage());
            } catch (LimitExceededException lee) {
                System.out.println(lee.getMessage());
            }
        }

        System.out.println(mgmt);
        System.out.println("Number of passengers from city1 to city2 : "+mgmt.getCountOfPassengers("city1","city2"));
        System.out.println("Senior citizen in each bus : "+mgmt.getCountOfSeniorCitizens());
        System.out.println("List of all male passengers :"+mgmt.getPassengersByGender("M"));
        try {
            for (int i = 20; i < 45; i++)
                mgmt.cancelTicket(101, i);
        }catch(TicketDoesNotExist tdne){
            System.out.println(tdne);
        }catch(InvalidBusException tdne){
            System.out.println(tdne);
        }
        System.out.println("Number of passengers from city1 to city2 after cancellation: "+mgmt.getCountOfPassengers("city1","city2"));
    }
}