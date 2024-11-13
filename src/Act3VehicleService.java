public class Act3VehicleService {
    IVehicleInspector inspector;
    private static IEmissionsStrategy emissionsStrategy;
    VehicleFactory factory = new VehicleFactory();
    private static Act3VehicleService VSinstance;

    private Act3VehicleService(String prop) {
	    inspector = factory.getVehicleInspector(prop);
    }

    public static Act3VehicleService getVehicleService() {
        if(VSinstance == null) {
            String vi = System.getProperty("vi");
            String es = System.getProperty("es");
            VSinstance = new Act3VehicleService(vi);

            if(es.toLowerCase().compareTo("one") == 0) {
                emissionsStrategy = new OneEmissionStrategy();
            } else if (es.toLowerCase().compareTo("two") == 0) {
                emissionsStrategy = new TwoEmissionStrategy();
            } else {
                emissionsStrategy = new NullEmissionStrategy();
            }
        }

        return VSinstance;
    }

    /* Returns the total Service charge for all the vehicles
       that have gone through a full Service process */
    public int calculateTotal(IVehicle[] vehicles) {
        int total = 0;
        for(IVehicle vehicle : vehicles){
            total = total + emissionsStrategy.computeEmissionsFee(vehicle)  + vehicle.accept(inspector);
        }
        return total;
    }
}
