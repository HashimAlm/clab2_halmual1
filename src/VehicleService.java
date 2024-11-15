import java.util.Scanner;

public class VehicleService {
    IVehicleInspector inspector;
    VehicleFactory factory = new VehicleFactory();

    VehicleService() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 'Alt' for Alt Vehicle Inspector");
        String prop = scanner.nextLine();
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
