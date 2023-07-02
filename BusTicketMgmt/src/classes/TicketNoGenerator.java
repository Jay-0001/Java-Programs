package classes;
import java.util.HashMap;
public class TicketNoGenerator {
    static HashMap<Integer,Integer> generator = new HashMap<>();
    public TicketNoGenerator() {
    }
    public int generateTicketNo(int busNo){
        generator.put(busNo,generator.getOrDefault(busNo,0)+1);  //here is my doubt, since i am only using a single object shouldn't the hashmap be exclusive to that particular object and hence shouldn't the hashmap entries be incremented continuously
        //System.out.println(generator.get(busNo));
        return generator.get(busNo);
    }
}
