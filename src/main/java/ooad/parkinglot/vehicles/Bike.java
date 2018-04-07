package ooad.parkinglot.vehicles;

import ooad.parkinglot.enums.VehicleType;

public class Bike implements Vehicle {
    private VehicleType vehicleType = VehicleType.BIKE;

    @Override
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    @Override
    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
