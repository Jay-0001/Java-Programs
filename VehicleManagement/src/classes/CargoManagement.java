package classes;

import interfaces.*;

import java.util.*;

public class CargoManagement implements interfaces.ManageCargo {
    private ArrayList<VehicleDetails> vDetails = new ArrayList<>();
    private ArrayList<PackageDetails> pDetails = new ArrayList<>();

    public CargoManagement() {
    }
    public CargoManagement(ArrayList<VehicleDetails> vDetails, ArrayList<PackageDetails> pDetails) {
        this.vDetails = vDetails;
        this.pDetails = pDetails;
    }
    @Override
    public void addPackageToVehicle(PackageDetails pd, int id) throws InvalidVehicleException, VehicleCapacityExceeded {
        for(VehicleDetails vehicle : vDetails){
            if(vehicle.getVehicleId()==id){
              if(vehicle.getDetails().size()>vehicle.getCapacity())
                  throw new VehicleCapacityExceeded("Capacity exceeded");
              vehicle.getDetails().add(pd);
              return;
            }
            throw new InvalidVehicleException("Vehicle id does not exist");
        }
    }
    @Override
    public VehicleDetails fetchPackage(int id) {
        for(VehicleDetails v : vDetails){
            for(PackageDetails p:v.getDetails()){
                if(p.getPackageId()==id)
                    return v;
            }
        }
        return null;
    }
    @Override
    public void deliverPackage(int id) {
      for(PackageDetails pack:pDetails) {
          if (pack.getPackageId() == id) {
              pack.setStatus("Delivered");
              break;
          }
      }
      for(VehicleDetails v : vDetails){
          for(PackageDetails p:v.getDetails()){
              if(p.getPackageId()==id)               //the system is never wrong
                  p.setStatus("Delivered");
          }
      }
    }
    //we get ConcurrentModificationException when trying to modify the arraylist while iterating it already
     //can be overcome using an iterator
    @Override
    public List<PackageDetails> deliveryPendingPackages() {
        ArrayList<PackageDetails> packages = new ArrayList<>(pDetails);
        Iterator<PackageDetails> itr = packages.iterator();
        PackageDetails pd;
        while(itr.hasNext()){
            pd=itr.next();
            if(pd.getStatus()=="Delivered")
                itr.remove();
        }
        Collections.sort(packages, (pd1,pd2) -> (pd1.getPackageId()-pd2.getPackageId()));
        return packages;
    }
    @Override
    public HashMap<Integer, Integer> fetchUndeliveredPackages() {
        HashMap<Integer,Integer> summary = new HashMap<>();
        for(VehicleDetails vehicle : vDetails){
            int count =0;
            for(PackageDetails pd : vehicle.getDetails()){
                if(pd.getStatus()!="Delivered")
                    count++;
            }
            summary.put(vehicle.getVehicleId(),count);
        }
        return summary;
    }

    @Override
    public String toString() {
        return "CargoManagement{" +
                "vDetails=" + vDetails +
                ", pDetails=" + pDetails +
                '}';
    }
}
