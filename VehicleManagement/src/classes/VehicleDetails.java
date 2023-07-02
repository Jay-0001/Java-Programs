package classes;

import java.util.ArrayList;

public class VehicleDetails {
  private int vehicleId;
  private String vehicleName;
  private int capacity;
  private ArrayList<PackageDetails> details;
  public VehicleDetails() {

  }
  public VehicleDetails(int vehicleId, String vehicleName, int capacity, ArrayList<PackageDetails> details) {
        this.vehicleId = vehicleId;
        this.vehicleName = vehicleName;
        this.capacity = capacity;
        this.details = details;
  }
  public int getVehicleId() {
        return vehicleId;
  }
  public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
  }
  public String getVehicleName() {
        return vehicleName;
  }
  public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
  }
  public int getCapacity() {
        return capacity;
  }
  public void setCapacity(int capacity) {
        this.capacity = capacity;
  }
  public ArrayList<PackageDetails> getDetails() {
        return details;
  }
  public void setDetails(ArrayList<PackageDetails> details) {
        this.details = details;
  }
  void addPackage(PackageDetails pd){
      details.add(pd);
  }

  @Override
  public String toString() {
        return "VehicleDetails{" +
                "vehicleId=" + vehicleId +
                ", vehicleName='" + vehicleName + '\'' +    //includes a single quote character--backslash
                ", capacity=" + capacity +
                ", details=" + details +
                '}';
  }
}
