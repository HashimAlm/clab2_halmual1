public class OneEmissionStrategy implements IEmissionsStrategy {
    public int computeEmissionsFee(IVehicle vehicle) {
        return (int) Math.min(vehicle.co2Emissions() - 1000, 0);
    }
}
