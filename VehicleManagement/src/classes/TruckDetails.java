package classes;

import java.util.ArrayList;

public class TruckDetails extends VehicleDetails{
  double roadTax;
  public TruckDetails(double roadTax) {
        this.roadTax = roadTax;
  }
  public TruckDetails(int vehicleId, String vehicleName, int capacity, ArrayList<PackageDetails> details, double roadTax) {
        super(vehicleId, vehicleName, capacity, details);
        this.roadTax = roadTax;
  }
  public double getRoadTax() {
        return roadTax;
  }
  public void setRoadTax(double roadTax) {
        this.roadTax = roadTax;
  }
}
