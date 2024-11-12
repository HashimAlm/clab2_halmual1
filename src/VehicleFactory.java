public class VehicleFactory {

    public IVehicleInspector getVehicleInspector(String prop) {
        if(prop.toLowerCase().compareTo("alt") == 0) {
            return new AltVehicleInspection();
        } else {
            return new VehicleInspection();
        }
    }

}
