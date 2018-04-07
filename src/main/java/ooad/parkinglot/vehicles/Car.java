package ooad.parkinglot.vehicles;

import ooad.parkinglot.enums.VehicleType;

public class Car implements Vehicle {
    private VehicleType vehicleType = VehicleType.CAR;

    @Override
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    @Override
    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
