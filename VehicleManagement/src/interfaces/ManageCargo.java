package interfaces;
import classes.*;

import java.util.HashMap;
import java.util.List;

public interface ManageCargo {
    void addPackageToVehicle(PackageDetails pd,int id) throws InvalidVehicleException,VehicleCapacityExceeded;
    VehicleDetails fetchPackage(int id);
    void deliverPackage(int id);
    List<PackageDetails> deliveryPendingPackages();
    HashMap<Integer,Integer> fetchUndeliveredPackages();
}
