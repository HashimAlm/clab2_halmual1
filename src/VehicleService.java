public class VehicleService {
    IVehicleInspector inspector;
    VehicleFactory factory = new VehicleFactory();

    VehicleService() {
	    inspector = factory.getVehicleInspector("");
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
