package interfaces;
public class VehicleCapacityExceeded extends Exception{
    public VehicleCapacityExceeded(){
    }
    public VehicleCapacityExceeded(String msg){
        super(msg);
    }
}
