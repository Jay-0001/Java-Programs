package interfaces;
public class InvalidVehicleException extends Exception {
    public InvalidVehicleException() {
    }
    public InvalidVehicleException(String msg){   //why the need of explicit mention ??
        super(msg);
    }

}
