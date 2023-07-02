import classes.*;
import interfaces.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CargoDemo {
    public static void main(String[] args) {
        ArrayList<PackageDetails> pDetails = new ArrayList<>();
        for(int i=1,id=100;i<118;i++)
            pDetails.add(new PackageDetails(id+i,"Undelivered"));
        ArrayList<VehicleDetails> vDetails = new ArrayList<>();
        vDetails.add(new TruckDetails(001,"Truck1",7,new ArrayList<>(pDetails.subList(0,3)),1000));
        vDetails.add(new TruckDetails(002,"Truck2",5,new ArrayList<>(pDetails.subList(5,6)),1100));
        vDetails.add(new AirCargoDetails(003,"Flight1",7,new ArrayList<>(pDetails.subList(9,11)),10000));
        CargoManagement cm = new CargoManagement(vDetails,pDetails);

        System.out.println(cm);
        try {
            cm.addPackageToVehicle(new PackageDetails(115,"Undelivered"),001);
            cm.addPackageToVehicle(new PackageDetails(116,"Undelivered"),002);
            cm.addPackageToVehicle(new PackageDetails(117,"Undelivered"),003);
        }catch(InvalidVehicleException ive){
            System.out.println(ive.getMessage());
        }catch(VehicleCapacityExceeded vce){
            System.out.println(vce.getMessage());
        }
        System.out.println("Vehicle with package 101 "+cm.fetchPackage(101));
        for(int i=101;i<110;i++)
            cm.deliverPackage(i);
        cm.deliverPackage(112);
        System.out.println("exited");
        System.out.println(cm.deliveryPendingPackages());
        System.out.println(cm.fetchUndeliveredPackages());
    }
}