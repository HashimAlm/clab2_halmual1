import java.util.Scanner;

public class AltVehicleService {
    IVehicleInspector inspector;
    VehicleFactory factory = new VehicleFactory();

    AltVehicleService(String prop) {
	    inspector = factory.getVehicleInspector(prop);
    }

    /* Returns the total Service charge for all the vehicles
       that have gone through a full Service process */
    public int calculateTotal(IVehicle[] vehicles) {
        int total = 0;
        for(IVehicle vehicle : vehicles){
            total = total + vehicle.accept(inspector);
        }
        return total;
    }
}
