public class TwoEmissionStrategy implements IEmissionsStrategy {
    public int computeEmissionsFee(IVehicle vehicle) {
        return (int) Math.min(vehicle.co2Emissions() - 1100, 10);
    }
}
