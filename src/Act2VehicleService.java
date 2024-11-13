public class Act2VehicleService {
    IVehicleInspector inspector;
    VehicleFactory factory = new VehicleFactory();
    private static Act2VehicleService VSinstance;

    private Act2VehicleService(String prop) {
        
	    inspector = factory.getVehicleInspector(prop);
    }

    public static Act2VehicleService getVehicleService() {
        if(VSinstance == null) {
            String vi = System.getProperty("vi");
            VSinstance = new Act2VehicleService(vi);
        }

        return VSinstance;
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
