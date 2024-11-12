public class VehicleFactory {
    
    public IVehicleInspector getVehicleInspector(String prop) {
        return new AltVehicleInspection();
    }

}
