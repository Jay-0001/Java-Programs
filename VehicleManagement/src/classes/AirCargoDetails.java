package classes;

import java.util.ArrayList;

public class AirCargoDetails extends VehicleDetails{
  private double airForce;
  public AirCargoDetails() {

  }
  public AirCargoDetails(int vehicleId, String vehicleName, int capacity, ArrayList<PackageDetails> details, double airForce) {
        super(vehicleId, vehicleName, capacity, details);
        this.airForce = airForce;
  }
    public double getAirForce() {
        return airForce;
    }
    public void setAirForce(double airForce) {
        this.airForce = airForce;
    }
}
