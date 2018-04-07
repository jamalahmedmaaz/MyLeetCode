package ooad.parkinglot.vehicles;

import ooad.parkinglot.enums.VehicleType;

public class Bus implements Vehicle {
    private VehicleType vehicleType = VehicleType.BUS;

    @Override
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    @Override
    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
